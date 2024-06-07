package Servlet.OrderServlet;

import Service.OrderService;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "OrderDeleteServlet", urlPatterns = "/Order_Delete")
public class OrderDeleteServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        JSONObject jsonObject = new JSONObject();
        if(orderService.deleteOrder(orderId)){
            jsonObject.put("code", true);
            jsonObject.put("msg", "删除订单成功!");
        }else {
            jsonObject.put("code", false);
            jsonObject.put("msg", "删除订单失败!");
        }

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
