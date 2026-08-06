package thread.cf;

import thread.cf.data.*;

import java.util.concurrent.*;


/*
* Scenario
You are building an API endpoint GET /api/v1/checkout/summary/{userId} for an e-commerce platform. When a user lands on the checkout screen, your service must aggregate data from 4 independent downstream microservices to render the summary page.


               ┌──► User Profile Service (Name, Saved Cards) ──┐
               ├──► Inventory Service (Stock Availability)   ──┤
Checkout API ──┤                                               ├──► Aggregated Checkout Summary
               ├──► Shipping Service (Calculate Rates)       ──┤
               └──► Pricing & Promo Service (Discounts)       ──┘
🛠️ Performance & SLA Requirements
Non-Blocking Orchestration:
User Profile & Inventory can be fetched in parallel.
Shipping Service requires the user's shipping address (from User Profile) and item details (from Inventory),
* so it must run after both finish.
Pricing & Promo Service can run concurrently with Shipping once item details are ready.
Strict Timeout Limits:
Overall request SLA is 800ms. If any downstream call takes longer than 500ms, apply a fallback.
Graceful Fallbacks (Resilience):
If Pricing & Promo Service fails/times out → apply 0% discount and continue.
If Shipping Service fails/times out → return a standard flat rate of $9.99.
If User Profile or Inventory fails → throw a hard CheckoutException (these are critical).
* */
public class EComCheckOut {

    // 1. Dedicated custom executor to avoid starving the common ForkJoinPool
    private final ExecutorService checkoutExecutor = new ThreadPoolExecutor(
            10,                             // Core pool size
            50,                             // Max pool size
            60L, TimeUnit.MICROSECONDS,          // Keep-alive time
            new ArrayBlockingQueue<>(500),  // Queue capacity
            new ThreadPoolExecutor.CallerRunsPolicy() // Backpressure handler
    );

    private final MicroserviceClients clients;

    public EComCheckOut(MicroserviceClients clients) {
        this.clients = clients;
    }

    public CompletableFuture<CheckoutSummary> getCheckoutSummary(String userId, String cartId) {

        // --- STEP 1: Parallel Fetch (User Profile & Inventory) ---

        CompletableFuture<UserProfile> profileFuture = clients.getUserProfile(userId);

        // Hard failure required if profile fails (propagated via completion stage)

        CompletableFuture<InventoryStatus> inventoryFuture = clients.getInventory(cartId);
        // Hard failure required if inventory fails

        // --- STEP 2: Dependent Fetch (Shipping requires Profile & Inventory) ---

        CompletableFuture<ShippingOption> shippingFuture = profileFuture
                .thenCombineAsync(inventoryFuture, (profile, inventory) -> {
                    // Once both profile and inventory arrive, call shipping service
                    return clients.getShippingRate(profile.address(), inventory.itemIds());
                }, checkoutExecutor)
                .thenComposeAsync(future -> future, checkoutExecutor) // Flatten nested CompletableFuture
                         .exceptionally(ex -> {
                    // Graceful Fallback for Shipping
                    System.err.println("Shipping Service failed/timed out. Using fallback. Cause: " + ex.getMessage());
                    return new ShippingOption("Standard Flat Rate", 9.99);
                });

        // --- STEP 3: Concurrent Fetch (Pricing requires Inventory & Profile Tier) ---

        CompletableFuture<PricingSummary> pricingFuture = profileFuture
                .thenCombineAsync(inventoryFuture, (profile, inventory) -> {
                    return clients.getPricing(cartId, profile.tier());
                }, checkoutExecutor)
                .thenComposeAsync(future -> future, checkoutExecutor)
              //  .orTimeout(500, TimeUnit.MILLISECONDS)
                .exceptionally(ex -> {
                    // Graceful Fallback for Pricing
                    System.err.println("Pricing Service failed/timed out. Using fallback. Cause: " + ex.getMessage());
                    return new PricingSummary(100.0, 100.0); // 0% discount fallback
                });

        // --- STEP 4: Aggregate All 4 Results into CheckoutSummary ---

        return CompletableFuture.allOf(profileFuture, inventoryFuture, shippingFuture, pricingFuture)
                .thenApplyAsync(v -> {
                    // Join is safe here because allOf guarantees all futures are completed
                    UserProfile profile = profileFuture.join();
                    InventoryStatus inventory = inventoryFuture.join();
                    ShippingOption shipping = shippingFuture.join();
                    PricingSummary pricing = pricingFuture.join();

                    return new CheckoutSummary(profile, inventory, shipping, pricing);
                }, checkoutExecutor);
    }
}
