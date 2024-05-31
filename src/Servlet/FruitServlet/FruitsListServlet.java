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

@WebServlet(name = "FruitsListServlet", urlPatterns = "/Fruits_List")
public class FruitsListServlet extends HttpServlet {
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classifyId = Integer.parseInt(request.getParameter("classifyId"));    //0全部  1~..为类别
        List<Fruit> list = null;
        if(classifyId == 0){
            list = fruitService.getAllFruitList();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for(Fruit f: list){
                f.setClassify();
                jsonObject.put("fruit", f);
                jsonArray.add(jsonObject);
            }

            JSONObject returnObject = new JSONObject();
            returnObject.put("code", true);
            returnObject.put("classifyName", "all");
            returnObject.put("fruitList", jsonArray);

            PrintWriter out = response.getWriter();
            out.print(returnObject);
            out.flush();
            out.close();
        }else{
            list = fruitService.getFruitListByClassifyId(classifyId);

            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            String classifyName = null;
            for(Fruit f: list){
                f.setClassify();
                classifyName = f.getClassify().getClassifyName();
                jsonObject.put("fruit", f);
                jsonArray.add(jsonObject);
            }

            JSONObject returnObject = new JSONObject();
            returnObject.put("code", true);
            returnObject.put("classifyName", classifyName);
            returnObject.put("fruitList", jsonArray);

            PrintWriter out = response.getWriter();
            out.print(returnObject);
            out.flush();
            out.close();
        }
    }
}
