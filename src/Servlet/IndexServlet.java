package Servlet;

import Service.FruitService;
import model.Fruit;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Fruit> hotList = fruitService.getHotFruit(1);
        JSONObject jsonObject1 = new JSONObject();
        JSONArray hotArray = new JSONArray();
        jsonObject1.put("code", "true");
        jsonObject1.put("type", "hot");
        for(Fruit f : hotList){
            hotArray.add(f);
        }
        jsonObject1.put("hotList", hotArray);

        List<Fruit> newList = fruitService.getNewFruit(2);
        JSONObject jsonObject2 = new JSONObject();
        JSONArray newArray = new JSONArray();
        jsonObject2.put("code", "true");
        jsonObject2.put("type", "new");
        for(Fruit f : newList){
            newArray.add(f);
        }
        jsonObject2.put("newList", newList);

        PrintWriter out = response.getWriter();
        out.print(jsonObject1);
        out.print(jsonObject2);
        out.flush();
        out.close();
    }
}
