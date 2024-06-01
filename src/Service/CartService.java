package Service;

import dao.CartDao;
import model.CartDetail;
import model.ShopCart;

import java.sql.SQLException;

public class CartService {
    private CartDao cartDao = new CartDao();

    public boolean haveCart(int userId){
        try {
            if(cartDao.getShopCart(userId) != null){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ShopCart getCart(int userId){
        try {
            return cartDao.getShopCart(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCart(int userId){
        try {
            cartDao.insertShopCart(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addFruitIntoCart(CartDetail cartDetail){
        try {
            cartDao.insertCartDetail(cartDetail);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public
}
