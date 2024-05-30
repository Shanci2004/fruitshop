package Servlet;

import dao.AddressDao;
import model.Address;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "QueryAddressServlet", urlPatterns = "/Query_Address")
public class QueryAddressServlet extends HttpServlet {
    private AddressDao addressDao = new AddressDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        try {
            List<Address> addresseslist = addressDao.selectAddressbyUserId(userId);
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            int i = 0;
            for(Address adrs: addresseslist){
                jsonObject.put("index", i);
                jsonObject.put("address", adrs);
                jsonArray.add(jsonObject);
            }

            JSONObject returnObject = new JSONObject();
            returnObject.put("code", true);
            returnObject.put("msg", "查询地址成功！");
            returnObject.put("AddressList", jsonArray);

            PrintWriter out = response.getWriter();
            out.print(returnObject);
            out.flush();
            out.close();

        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",false);
            jsonObject.put("msg","查询地址出错！");

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }

    }
}
