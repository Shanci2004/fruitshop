package Servlet.CartServlet;

import Service.CartService;
import model.ShopCart;
import model.User;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CartCountServlet", urlPatterns = "/Cart_Count")
public class CartCountServlet extends HttpServlet {
    private CartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");

        ShopCart cart = cartService.getCart(user.getUserId());

        int count = cartService.getCartCount(cart.getCartId());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "查询成功");
        jsonObject.put("count", count);

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
