package Servlet;

import Service.FruitService;
import model.Fruit;
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
        jsonObject1.put("code", "success");
        jsonObject1.put("type", "hot");
        jsonObject1.put("hotList", hotList);

        List<Fruit> newList = fruitService.getNewFruit(2);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("code", "success");
        jsonObject2.put("type", "new");
        jsonObject2.put("newList", newList);

        PrintWriter out = response.getWriter();
        out.print(jsonObject1);
        out.print(jsonObject2);
        out.flush();
        out.close();
    }
}
