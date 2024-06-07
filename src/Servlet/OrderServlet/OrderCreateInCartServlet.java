package Servlet.OrderServlet;

import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "OrderCreateInCartServlet", urlPatterns = "/Order_Create")
public class OrderCreateInCartServlet extends HttpServlet {
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

    }
}
