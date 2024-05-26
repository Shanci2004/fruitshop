package Servlet;

import Service.UserService;
import model.User;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ua = request.getParameter("ua");
        String password = request.getParameter("password");
        User user = userService.login(ua, password);
        if(user == null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", false);
            jsonObject.put("failMsg", "用户名或账号或密码错误，请重新登录！");
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", true);
            jsonObject.put("msg", "登录成功！欢迎您，" + user.getUserName());
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
        }
    }
}
