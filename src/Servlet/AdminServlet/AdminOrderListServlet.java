package Servlet.AdminServlet;

import Service.AddressService;
import Service.FruitService;
import Service.OrderService;
import Service.UserService;
import model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AdminOrderListServlet", urlPatterns = "/Admin_OrderList")
public class AdminOrderListServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    private UserService userService = new UserService();
    private AddressService addressService = new AddressService();
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orderList = orderService.getAllOrderList();
        JSONArray orderArray = new JSONArray();
        for(Order order: orderList){
            User user = userService.getUserById(order.getUserId());
            Address address = addressService.getAddressByAddressId(order.getAddressId());
            List<OrderItems> orderItems = orderService.getOrderItems(order.getOrderId());
            JSONObject userObject = new JSONObject();
            userObject.put("user", user);
            JSONObject addressObject = new JSONObject();
            addressObject.put("address", address);
            orderArray.add(order);
            orderArray.add(userObject);
            orderArray.add(addressObject);
            JSONObject itemsObject = new JSONObject();
            for(int i = 0; i < orderItems.size(); i++){
                Fruit fruit = fruitService.getFruitInfo(orderItems.get(i).getFruitId());
                itemsObject.put("orderitems", orderItems.get(i));
                itemsObject.put("fruit", fruit);
                orderArray.add(itemsObject);
            }
        }

        JSONObject returnObject = new JSONObject();
        returnObject.put("code", true);
        returnObject.put("msg", "查询订单列表成功!");
        returnObject.put("orderList", orderArray);

        PrintWriter out = response.getWriter();
        out.print(returnObject);
        out.flush();
        out.close();
    }
}
