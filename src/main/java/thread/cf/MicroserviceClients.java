package thread.cf;

import thread.cf.data.InventoryStatus;
import thread.cf.data.PricingSummary;
import thread.cf.data.ShippingOption;
import thread.cf.data.UserProfile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MicroserviceClients implements Clients{
    @Override
    public CompletableFuture<UserProfile> getUserProfile(String userId) {
        return CompletableFuture.supplyAsync(() -> new UserProfile(Rolling.USER_ID, "Test Address", "3"));
    }

    @Override
    public CompletableFuture<InventoryStatus> getInventory(String cartId) {
        return CompletableFuture.supplyAsync(() -> new InventoryStatus(Rolling.CART_ID, List.of("1","2"), true));
    }

    @Override
    public CompletableFuture<ShippingOption> getShippingRate(String address, List<String> itemIds) {
        return CompletableFuture.supplyAsync(() -> new ShippingOption("Provider 1", 33d));
    }

    @Override
    public CompletableFuture<PricingSummary> getPricing(String cartId, String tier) {
        return CompletableFuture.supplyAsync(() -> new PricingSummary(76d, 50d));
    }
}
