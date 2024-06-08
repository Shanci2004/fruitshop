package Servlet.AdminServlet;

import Service.FruitService;
import model.Fruit;
import net.sf.json.JSONObject;
import utiils.FruitImageUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AdminFruitModifyServlet", urlPatterns = "/Admin_FruitModify")
public class AdminFruitModifyServlet extends HttpServlet {
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fruitId = Integer.parseInt(request.getParameter("fruitId"));

        String fruitName = request.getParameter("fruitName");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String intro = request.getParameter("intro");
        int classifyId = Integer.parseInt(request.getParameter("classifyId"));

        Fruit fruit = fruitService.getFruitInfo(fruitId);
        fruit.setFruitName(fruitName);
        fruit.setPrice(price);
        fruit.setStock(stock);
        fruit.setIntro(intro);
        fruit.setClassifyId(classifyId);
        fruit.setClassify();

        Part coverPart = request.getPart("cover");
        Part image1Part = request.getPart("image1");
        Part image2Part = request.getPart("image2");
        Part image3Part = request.getPart("image3");
        Part image4Part = request.getPart("image4");
        if(coverPart != null){
            String cover = FruitImageUtils.addImage(coverPart);
            fruit.setCover(cover);
        }
        if(image1Part != null){
            String image1 = FruitImageUtils.addImage(image1Part);
            fruit.setImage1(image1);
        }if(image2Part != null){
            String image2 = FruitImageUtils.addImage(image2Part);
            fruit.setImage2(image2);
        }if(image3Part != null){
            String image3 = FruitImageUtils.addImage(image3Part);
            fruit.setImage3(image3);
        }if(image4Part != null){
            String image4 = FruitImageUtils.addImage(image4Part);
            fruit.setImage4(image4);
        }
        fruitService.modifyFruit(fruit);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "修改商品信息成功!");
        jsonObject.put("fruit", fruit);

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
