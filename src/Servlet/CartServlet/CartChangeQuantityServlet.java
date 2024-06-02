package Servlet.CartServlet;

import Service.CartService;
import model.ShopCart;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CartChangeQuantityServlet", urlPatterns = "/Cart_ChangeQuantity")
public class CartChangeQuantityServlet extends HttpServlet {
    private CartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopCart cart = (ShopCart) request.getSession().getAttribute("cart");

        int fruitId = Integer.parseInt(request.getParameter("fruitId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if(quantity == 0){
            cartService.deleteFruitFromCart(cart.getCartId(), fruitId);
        }else{
            cartService.changeFruitQuantity(cart.getCartId(), fruitId, quantity);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "更改商品数量成功");

        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }
}
