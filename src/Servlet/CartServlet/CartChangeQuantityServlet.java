package Servlet.CartServlet;

import Service.CartService;
import model.ShopCart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
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

    }
}
