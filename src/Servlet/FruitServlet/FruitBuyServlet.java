package Servlet.FruitServlet;

import Service.OrderService;
import model.Order;
import model.OrderItems;
import model.User;
import net.sf.json.JSONObject;
import utiils.OrderIdUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "FruitBuyServlet", urlPatterns = "/Fruit_Buy")
public class FruitBuyServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderDate = ft.format(date);
        int status = 2;
        int paytype = Integer.parseInt(request.getParameter("paytype"));
        int fruitId = Integer.parseInt(request.getParameter("fruitId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double subtotal = Double.parseDouble(request.getParameter("subtotal"));
        double total = subtotal;    //直接购买，只有一种商品
        String orderId = OrderIdUtils.createOrderId(date, user, fruitId);
        Order order = new Order(orderId, user.getUserId(), addressId, orderDate, status, paytype, total);
        OrderItems orderItems = new OrderItems(orderId, fruitId, quantity, subtotal);
        orderService.buyFruit(order, orderItems);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "购买成功");

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
