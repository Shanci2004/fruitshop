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
        JSONObject hotObject = new JSONObject();
        JSONArray hotArray = new JSONArray();
        for(Fruit f: hotList){
            hotObject.put("hotfruit", f);
            hotArray.add(hotObject);
        }
        JSONObject returnObject1 = new JSONObject();
        returnObject1.put("code", true);
        returnObject1.put("hotList", hotArray);

        List<Fruit> newList = fruitService.getNewFruit(2);
        JSONObject newObject = new JSONObject();
        JSONArray newArray = new JSONArray();
        for(Fruit f: newList){
            newObject.put("newfruit", f);
            newArray.add(newObject);
        }
        JSONObject returnObject2 = new JSONObject();
        returnObject2.put("code", true);
        returnObject2.put("newList", newArray);

        PrintWriter out = response.getWriter();
        out.print(returnObject1);
        out.print(returnObject2);
        out.flush();
        out.close();
    }
}
