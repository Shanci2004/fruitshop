package Servlet.AddressServlet;

import Service.AddressService;
import model.Address;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AddAddressServlet", urlPatterns = "/Add_Address")
public class AddAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Address address = new Address();
        try {
            BeanUtils.copyProperties(address, request.getParameterMap());
            int userId = Integer.parseInt(request.getParameter("userId"));
            address.setUserId(userId);
            addressService.addAddress(address);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",true);
            jsonObject.put("msg","添加地址成功！");
            jsonObject.put("address",address);

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",false);
            jsonObject.put("msg","添加地址出错！");

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }

    }
}
