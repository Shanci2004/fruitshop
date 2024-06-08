package Servlet.AdminServlet;

import Service.FruitService;
import model.Fruit;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AdminFruitListServlet", urlPatterns = "/Admin_FruitList")
public class AdminFruitListServlet extends HttpServlet {
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Fruit> fruitList = fruitService.getAllFruitList();
        JSONArray fruitArray = new JSONArray();
        for(Fruit fruit: fruitList){
            fruitArray.add(fruit);
        }

        JSONObject returnObject = new JSONObject();
        returnObject.put("code", true);
        returnObject.put("msg", "查询商品列表成功!");
        returnObject.put("fruitList", fruitArray);

        PrintWriter out = response.getWriter();
        out.print(returnObject);
        out.flush();
        out.close();
    }
}
