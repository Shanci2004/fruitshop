package Servlet.AdminServlet;

import Service.UserService;
import model.User;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AdminResetUserPwdServlet", urlPatterns = "/Admin_ResetUserPwd")
public class AdminResetUserPwdServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.getUserById(userId);
        user.setPassword("123456");
        userService.changePwd(user);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", true);
        jsonObject.put("msg", "修改用户密码成功!");

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
