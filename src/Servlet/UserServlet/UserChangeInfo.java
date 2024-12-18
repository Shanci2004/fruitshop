package Servlet.UserServlet;

import Service.UserService;
import model.User;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UserChangeInfo", urlPatterns = "/User_ChangeInfo")
@MultipartConfig
public class UserChangeInfo extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        //获取头像图片存入Part中
        Part avatar = request.getPart("avatar");
        //storePath将头像存入某处
        String storePath = "C:\\Users\\29424\\Desktop\\小组实验\\FruitShop\\web\\avatar\\";
        //
        String filename = avatar.getSubmittedFileName();//保证图片名不重复
        storePath += filename;
        avatar.write(storePath);


        String avatarname = "avatar/" + filename;
        user.setUserName(request.getParameter("userName"));
        user.setPhone(request.getParameter("phone"));
        user.setAvatar(avatarname);

        userService.changeInfo(user);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "修改用户信息成功");
        jsonObject.put("user", user);

        request.getSession().setAttribute("user", user);

        PrintWriter out =  response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
