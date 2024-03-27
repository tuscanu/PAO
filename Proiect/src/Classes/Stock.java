package Classes;

public class Stock extends Product {
    private int quantity;

    public Stock(String name, double price, Category category, int quantity) {
        super(name, price, category);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
