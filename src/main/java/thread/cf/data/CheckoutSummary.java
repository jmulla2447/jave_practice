package thread.cf.data;

public record CheckoutSummary(
        UserProfile profile,
        InventoryStatus inventory,
        ShippingOption shipping,
        PricingSummary pricing
) {}
