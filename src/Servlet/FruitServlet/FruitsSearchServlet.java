package Servlet.FruitServlet;

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

@WebServlet(name = "FruitsSearchServlet", urlPatterns = "/Fruits_Search")
public class FruitsSearchServlet extends HttpServlet {
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        if(keyword.equals("")){

        }else{
            List<Fruit> list = fruitService.searchFruit(keyword);
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for(Fruit f: list){
                f.setClassify();
                jsonObject.put("fruit", f);
                jsonArray.add(jsonObject);
            }

            JSONObject returnObject = new JSONObject();
            returnObject.put("code", true);
            returnObject.put("backList", jsonArray);

            PrintWriter out = response.getWriter();
            out.print(returnObject);
            out.flush();
            out.close();
        }
    }
}
