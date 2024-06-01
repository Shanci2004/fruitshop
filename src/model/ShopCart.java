package model;

public class ShopCart  {
    private int cartId;
    private int userId;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ShopCart(int cartId, int userId) {
        this.cartId = cartId;
        this.userId = userId;
    }

    public ShopCart() {
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                '}';
    }
}
