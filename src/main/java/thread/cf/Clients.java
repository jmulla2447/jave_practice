package thread.cf;

import thread.cf.data.InventoryStatus;
import thread.cf.data.PricingSummary;
import thread.cf.data.ShippingOption;
import thread.cf.data.UserProfile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface Clients {
    CompletableFuture<UserProfile> getUserProfile(String userId);
    CompletableFuture<InventoryStatus> getInventory(String cartId);
    CompletableFuture<ShippingOption> getShippingRate(String address, List<String> itemIds);
    CompletableFuture<PricingSummary> getPricing(String cartId, String tier);
}
