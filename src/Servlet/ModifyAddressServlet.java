package Servlet;

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

@WebServlet(name = "ModifyAddressServlet", urlPatterns = "/Modify_Address")
public class ModifyAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Address address = new Address();

        try {
            BeanUtils.copyProperties(address, request.getParameterMap());
            int userId = Integer.parseInt(request.getParameter("userId"));
            int addressId = Integer.parseInt(request.getParameter("addressId"));
            address.setUserId(userId);
            address.setAddressId(addressId);

            addressService.changeAddress(address);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",true);
            jsonObject.put("msg","修改地址成功！");
            jsonObject.put("newAddress",address);

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();

        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",false);
            jsonObject.put("msg","修改地址出错！");

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }

    }
}
