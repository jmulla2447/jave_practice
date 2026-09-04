package core.java.practice.dp.visiotr;

public class Glass extends Item {

    private int price;

    public int accept(ShoppingCartVisitor visitor) {
        return visitor.calculatePrice(this);
    }


    public void setPrice(int price){
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
    }
}
