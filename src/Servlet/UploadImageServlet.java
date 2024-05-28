package Servlet;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UploadImageServlet", urlPatterns = "/Upload_Image")
@MultipartConfig
public class UploadImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取头像图片存入Part中
        Part avatar = request.getPart("avatar");
        //storePath将头像存入某处
        String storePath = getServletContext().getRealPath("avatar");
        new File(storePath).mkdirs();
        //
        String filename = System.currentTimeMillis() + avatar.getSubmittedFileName();//保证图片名不重复
        avatar.write(storePath + "/" + filename);

    }
}
