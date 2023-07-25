package core.java.practice.dp.visiotr;

public class ToothPaste implements Item {

    private int price;

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.calculatePrice(this);
    }


    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
