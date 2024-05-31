package Servlet.UserServlet;

import Service.UserService;
import model.User;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UserChangePwd", urlPatterns = "/User_ChangePwd")
public class UserChangePwd extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String newPwd = request.getParameter("newPwd");

        User user = (User) request.getSession().getAttribute("user");

        if(user.getPassword().equals(password)){
            user.setPassword(newPwd);
            userService.changePwd(user);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", true);
            jsonObject.put("msg", "修改密码成功");

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", false);
            jsonObject.put("msg", "修改密码失败，旧密码错误！");

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }
    }
}
