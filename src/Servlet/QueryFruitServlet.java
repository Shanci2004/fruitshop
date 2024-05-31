package Servlet;

import Service.FruitService;
import model.Fruit;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "QueryFruitServlet", urlPatterns = "/Query_Fruit")
public class QueryFruitServlet extends HttpServlet {
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fruitId = Integer.parseInt(request.getParameter("fruitId"));

        Fruit fruit = fruitService.getFruitInfo(fruitId);
        fruit.setClassify();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("fruit", fruit);

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
