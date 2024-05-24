package Servlet;

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
            JSONArray jsonArray = new JSONArray();
            int j = 10;
            for(int i = 0; i < 10; i++){
                jsonObject.put("i", i);
                jsonObject.put("j", j);
                jsonArray.add(jsonObject);
            }

            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("meta", jsonArray);
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }else{

        }
    }
}
