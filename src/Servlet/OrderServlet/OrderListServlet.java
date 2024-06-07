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
            Address address = addressService.getAddressByAddressId(order.getAddressId());
            orderObject.put("order", order);
            orderObject.put("user", user);
            orderObject.put("address", address);
            for(int i = 0; i < itemsList.size(); i++){
                Fruit fruit = fruitService.getFruitInfo(itemsList.get(i).getFruitId());
                itemsObject.put("orderitems", itemsList.get(i));
                itemsObject.put("fruit", fruit);
                orderObject.put("items", itemsObject);
                orderArray.add(orderObject);
            }
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
