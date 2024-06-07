package Service;

import dao.CartDao;
import dao.FruitDao;
import dao.OrderDao;
import model.Order;
import model.OrderItems;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private FruitService fruitService = new FruitService();

    public void buyFruit(Order order, OrderItems orderItems){
        try {
            orderDao.insertOrder(order);
            orderDao.insertOrderItems(orderItems);
            fruitService.lessenFruit(orderItems.getFruitId(), orderItems.getQuantity());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void buyFruitInCart(Order order, OrderItems[] orderItems){
        try {
            orderDao.insertOrder(order);
            for(OrderItems oi: orderItems){
                orderDao.insertOrderItems(oi);
                fruitService.lessenFruit(oi.getFruitId(), oi.getQuantity());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> getOrderList(int userId){
        try {
            return orderDao.selectOrderList(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<OrderItems> getOrderItems(String orderId){
        try {
            return orderDao.selectOrderItems(orderId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
