package Servlet.AdminServlet;

import Service.UserService;
import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AdminUserListServlet", urlPatterns = "/Admin_UserList")
public class AdminUserListServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = userService.getUserList();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(User user: list){
            jsonObject.put("user", user);
            jsonArray.add(jsonObject);
        }

        JSONObject returnObject = new JSONObject();
        returnObject.put("code", true);
        returnObject.put("msg", "查询用户列表成功!");
        returnObject.put("userList", jsonArray);

        PrintWriter out = response.getWriter();
        out.print(returnObject);
        out.flush();
        out.close();
    }
}
