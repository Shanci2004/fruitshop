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

    public boolean buyFruit(Order order, OrderItems orderItems){
        try {
            if(fruitService.lessenFruit(orderItems.getFruitId(), orderItems.getQuantity())){
                orderDao.insertOrder(order);
                orderDao.insertOrderItems(orderItems);
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean buyFruitInCart(Order order, OrderItems[] orderItems){
        try {
            for(OrderItems oi : orderItems){
                if(!fruitService.fruitEnough(oi.getFruitId(), oi.getQuantity())){
                    return false;
                }
            }
            orderDao.insertOrder(order);
            for(OrderItems oi: orderItems){
                orderDao.insertOrderItems(oi);
                fruitService.lessenFruit(oi.getFruitId(), oi.getQuantity());
            }
            return true;
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

    public boolean deleteOrder(String orderId){
        try {
            if(orderDao.deleteOrder(orderId)){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
