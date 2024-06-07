package Servlet.AdminServlet;

import Service.OrderService;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AdminStatusServlet", urlPatterns = "/Admin_Status")
public class AdminStatusServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        int status = Integer.parseInt(request.getParameter("status"));

        orderService.updateStatus(orderId, status);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "更新状态成功!");

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
