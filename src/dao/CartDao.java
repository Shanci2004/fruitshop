package dao;

import model.CartDetail;
import model.ShopCart;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utiils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class CartDao {
    public ShopCart getShopCart(int userId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from shopcart where userId = ?";
        return runner.query(sql, new BeanHandler<ShopCart>(ShopCart.class), userId);
    }

    public CartDetail cartGetFruit(int cartId, int fruitId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from cartdetail where cartId = ? and fruitId = ?";
        return runner.query(sql, new BeanHandler<CartDetail>(CartDetail.class), cartId, fruitId);
    }

    public void insertShopCart(int userId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into shopcart(userId) values(?)";
        runner.update(sql, userId);
    }

    public void insertCartDetail(CartDetail cartDetail) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into cartdetail(cartId, fruitId, quantity, subtotal) values(?, ?, ?, ?)";
        runner.update(sql, cartDetail.getCartId(), cartDetail.getFruitId(), cartDetail.getQuantity(), cartDetail.getSubtotal());
    }

    public List<CartDetail> selectCartDetail(int cartId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from cartdetail where cartId = ?";
        return runner.query(sql, new BeanListHandler<CartDetail>(CartDetail.class), cartId);
    }

    public void updateFruitQuantity(int cartId, int fruitId, int quantity) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update cartdetail set quantity = ? where cartId = ? and fruitId = ?";
        runner.update(sql, quantity, cartId, fruitId);
    }

    public void deleteCartDetail(int cartId, int fruitId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from cartdetail where cartId = ? and fruitId = ?";
        runner.update(sql, cartId, fruitId);
    }
}
