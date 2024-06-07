package model;

public class OrderItems {
    private int orderDetailId;
    private String orderId;
    private int fruitId;
    private int quantity;
    private double subtotal;

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public OrderItems(String orderId, int fruitId, int quantity, double subtotal) {
        this.orderId = orderId;
        this.fruitId = fruitId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public OrderItems() {
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "orderDetailId=" + orderDetailId +
                ", orderId='" + orderId + '\'' +
                ", fruitId=" + fruitId +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}
