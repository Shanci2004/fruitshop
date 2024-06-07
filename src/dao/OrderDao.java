package dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.Order;
import model.OrderItems;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utiils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    public void insertOrder(Order order) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into `order` values(?, ?, ?, ?, ?, ?, ?)";
        runner.update(sql, order.getOrderId(), order.getUserId(), order.getAddressId(), order.getOrderDate(), order.getStatus(), order.getPaytype(), order.getTotal());
    }
    public void insertOrderItems(OrderItems orderItems) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into orderitems(orderId, fruitId, quantity, subtotal) values(?, ?, ?, ?)";
        runner.update(sql, orderItems.getOrderId(), orderItems.getFruitId(), orderItems.getQuantity(), orderItems.getSubtotal());
    }
    public List<Order> selectOrderList(int userId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from `order` where userId = ?";
        return runner.query(sql, new BeanListHandler<Order>(Order.class), userId);
    }
    public List<OrderItems> selectOrderItems(String orderId) throws SQLException {
        QueryRunner runner= new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from orderitems where orderId = ?";
        return runner.query(sql, new BeanListHandler<OrderItems>(OrderItems.class), orderId);
    }
    public boolean deleteOrder(String orderId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from `order` where orderId = ?";
        runner.update(sql, orderId);
        return true;
    }

}
