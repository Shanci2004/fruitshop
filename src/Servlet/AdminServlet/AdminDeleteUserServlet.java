package Servlet.AdminServlet;

import Service.UserService;
import model.User;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AdminDeleteUserServlet", urlPatterns = "/Admin_DeleteUser")
public class AdminDeleteUserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        JSONObject jsonObject = new JSONObject();
        if(userService.removeUser(userId)){
            jsonObject.put("code", true);
            jsonObject.put("msg", "删除用户成功!");
        }else {
            jsonObject.put("code", true);
            jsonObject.put("msg", "删除用户失败!");
        }

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
