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

@WebServlet(name = "AdminFruitAddServlet", urlPatterns = "/Admin_AddFruit")
public class AdminFruitAddServlet extends HttpServlet {
    private FruitService fruitService = new FruitService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fruitName = request.getParameter("fruitName");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int sales = 0;
        Part coverPart = request.getPart("cover");
        Part image1Part = request.getPart("image1");
        Part image2Part = request.getPart("image2");
        Part image3Part = request.getPart("image3");
        Part image4Part = request.getPart("image4");
        String cover = FruitImageUtils.addImage(coverPart);
        String image1 = FruitImageUtils.addImage(image1Part);
        String image2 = FruitImageUtils.addImage(image2Part);
        String image3 = FruitImageUtils.addImage(image3Part);
        String image4 = FruitImageUtils.addImage(image4Part);
        String intro = request.getParameter("intro");
        int classifyId = Integer.parseInt(request.getParameter("classifyId"));

        Fruit fruit = new Fruit(fruitName, price, stock, sales, cover, image1, image2, image3, image4, intro, classifyId);
        fruit.setClassify();
        fruit.setImages();

        fruitService.addFruit(fruit);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "添加水果商品成功!");
        jsonObject.put("fruit", fruit);

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
