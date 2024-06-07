package Servlet.OrderServlet;

import Service.AddressService;
import Service.FruitService;
import Service.OrderService;
import model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "OrderListServlet", urlPatterns = "/Order_List")
public class OrderListServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    private FruitService fruitService = new FruitService();
    private AddressService addressService = new AddressService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orderList = orderService.getOrderList(user.getUserId());
        JSONObject orderObject = new JSONObject();
        JSONArray orderArray = new JSONArray();
        for(Order order: orderList){
            List<OrderItems> itemsList = orderService.getOrderItems(order.getOrderId());
            JSONObject itemsObject = new JSONObject();
            JSONArray itemsArray = new JSONArray();
            for(OrderItems oi: itemsList){
                Fruit fruit = fruitService.getFruitInfo(oi.getFruitId());
                itemsObject.put("orderitems", oi);
                itemsObject.put("fruit", fruit);
                itemsArray.add(itemsObject);
            }
            Address address = addressService.getAddressByAddressId(order.getAddressId());
            orderObject.put("order", order);
            orderObject.put("user", user);
            orderObject.put("address", address);
            orderObject.put("items", itemsArray);
            orderArray.add(orderObject);
        }

        JSONObject returnObject = new JSONObject();
        returnObject.put("code", true);
        returnObject.put("msg", "查询订单列表成功！");
        returnObject.put("orderList", orderArray);

        PrintWriter out = response.getWriter();
        out.print(returnObject);
        out.flush();
        out.close();
    }
}
