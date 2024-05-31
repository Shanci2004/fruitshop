package Servlet.UserServlet;

import Service.UserService;
import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UserRegisterServlet", urlPatterns = "/user_register")
public class UserRegisterServlet extends HttpServlet {
    private UserService uService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.copyProperties(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        if(uService.register(user)){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",true);
            jsonObject.put("msg","注册成功");
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }else{
            JSONObject jsonObject= new JSONObject();
            jsonObject.put("code",false);
            jsonObject.put("msg","注册失败");
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }
    }
}
