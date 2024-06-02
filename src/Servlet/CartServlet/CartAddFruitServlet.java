package Servlet.CartServlet;

import Service.CartService;
import Service.FruitService;
import model.CartDetail;
import model.Fruit;
import model.ShopCart;
import model.User;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CartAddFruitServlet", urlPatterns = "/Cart_AddFruit")
public class CartAddFruitServlet extends HttpServlet {
    private CartService cartService = new CartService();
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        int fruitId = Integer.parseInt(request.getParameter("fruitId"));
        Fruit fruit = fruitService.getFruitInfo(fruitId);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double subtotal = fruit.getPrice() * quantity;

        if(!cartService.haveCart(user.getUserId())){
            cartService.createCart(user.getUserId());
        }
        ShopCart shopCart = cartService.getCart(user.getUserId());

        if(cartService.cartHaveFruit(shopCart.getCartId(), fruitId)){
            cartService.changeFruitQuantity(shopCart.getCartId(), fruitId, quantity);
        }else{
            CartDetail cartDetail = new CartDetail(shopCart.getCartId(), fruitId, quantity, subtotal);
            cartService.addFruitIntoCart(cartDetail);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "添加商品至购物车成功！");

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
