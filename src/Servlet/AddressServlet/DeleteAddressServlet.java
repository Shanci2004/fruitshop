package Servlet.AddressServlet;

import Service.AddressService;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "DeleteAddressServlet", urlPatterns = "/Delete_Address")
public class DeleteAddressServlet extends HttpServlet {
    private AddressService addressService =new AddressService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        addressService.deleteAddress(addressId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",true);
        jsonObject.put("msg","删除地址成功！！");
        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
