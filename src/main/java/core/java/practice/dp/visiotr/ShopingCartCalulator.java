package core.java.practice.dp.visiotr;

public class ShopingCartCalulator implements ShoppingCartVisitor{
    @Override
    public int calculatePrice(Item item) {
        return item.getPrice();
    }
}
