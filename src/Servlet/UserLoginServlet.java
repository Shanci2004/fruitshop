package Servlet;

import Service.UserService;
import model.User;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/user_login")
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
            jsonObject.put("msg", "用户名或账号或密码错误，请重新登录！");
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
            request.getRequestDispatcher("/index").forward(request, response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", true);
            jsonObject.put("msg", "登录成功");
            jsonObject.put("user", user);
            jsonObject.put("isadmin", user.isIsadmin());
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
            request.getRequestDispatcher("/index").forward(request, response);
        }
    }
}
