package Servlet.CartServlet;

import Service.CartService;
import Service.FruitService;
import model.CartDetail;
import model.Fruit;
import model.ShopCart;
import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CartQueryServlet", urlPatterns = "/Cart_Query")
public class CartQueryServlet extends HttpServlet {
    private CartService cartService = new CartService();
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(!cartService.haveCart(user.getUserId())){
            cartService.createCart(user.getUserId());
        }
        ShopCart cart = cartService.getCart(user.getUserId());
        request.getSession().setAttribute("cart", cart);

        List<CartDetail> list = cartService.getCartDetailList(cart.getCartId());

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Fruit f = null;

        for(CartDetail cd: list){
            jsonObject.put("cartDetail", cd);
            f = fruitService.getFruitInfo(cd.getFruitId());
            f.setClassify();
            f.setImages();
            jsonObject.put("fruit", f);
            jsonArray.add(jsonObject);
        }

        JSONObject returnObject = new JSONObject();
        returnObject.put("code", true);
        returnObject.put("cartDetail", jsonArray);

        PrintWriter out = response.getWriter();
        out.print(returnObject);
        out.flush();
        out.close();

    }
}
