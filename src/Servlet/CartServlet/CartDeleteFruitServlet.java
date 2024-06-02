package Servlet.CartServlet;

import Service.CartService;
import model.ShopCart;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CartDeleteFruitServlet", urlPatterns = "/Cart_DeleteFruit")
public class CartDeleteFruitServlet extends HttpServlet {
    private CartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopCart cart = (ShopCart) request.getSession().getAttribute("cart");
        int fruitId = Integer.parseInt(request.getParameter("fruitId"));

        cartService.deleteFruitFromCart(cart.getCartId(), fruitId);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "删除商品成功！");

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
