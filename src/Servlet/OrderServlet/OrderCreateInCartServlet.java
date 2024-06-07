package Servlet.OrderServlet;

import Service.CartService;
import Service.OrderService;
import model.CartDetail;
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
import java.util.Arrays;
import java.util.Date;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "OrderCreateInCartServlet", urlPatterns = "/Order_Create")
public class OrderCreateInCartServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    private CartService cartService = new CartService();
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
        String orderId = OrderIdUtils.createOrderId(date, user);

        String str = request.getParameter("detailId");
        String[] split = str.split(",");
        int[] detailIds = new int[split.length];
        for(int i = 0; i < split.length; i++){
            detailIds[i] = Integer.parseInt(split[i]);
        }

        double total = 0;
        OrderItems[] orderItems = new OrderItems[detailIds.length];
        for(int i = 0; i < detailIds.length; i++){
            CartDetail cartDetail = cartService.getCartDetailById(detailIds[i]);
            total += cartDetail.getSubtotal();
            orderItems[i] = new OrderItems(orderId, cartDetail.getFruitId(), cartDetail.getQuantity(), cartDetail.getSubtotal());
        }

        Order order = new Order(orderId, user.getUserId(), addressId, orderDate, status, paytype, total);

        orderService.buyFruitInCart(order, orderItems);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "购买成功！");

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
