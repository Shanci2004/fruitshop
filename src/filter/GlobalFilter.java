package filter;

import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebFilter(filterName = "globalFilter", urlPatterns = {"/*"})
public class GlobalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        HttpServletResponse response = (HttpServletResponse)servletResponse;

        request.setCharacterEncoding("UTF-8");

        response.setCharacterEncoding("UTF-8");

        response.setContentType("application/json;charset=utf-8");

        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        //设置请求头信息
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        // 允许携带 cookies 等认证信息
        response.setHeader("Access-Control-Allow-Credentials", "true");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        filterChain.doFilter(servletRequest, response);

    }

    @Override
    public void destroy() {

    }
}
