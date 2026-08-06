package thread.cf.data;

import java.util.List;

public record InventoryStatus(String cartId, List<String> itemIds, boolean inStock) {}
