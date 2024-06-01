package model;

public class CartDetail {
    private int cartId;
    private int fruitId;
    private int quantity;
    private double subtotal;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public CartDetail(int cartId, int fruitId, int quantity, double subtotal) {
        this.cartId = cartId;
        this.fruitId = fruitId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public CartDetail() {
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "cartId=" + cartId +
                ", fruitId=" + fruitId +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}
