package top.clearlight.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responServlet")
public class ResponServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("response1");

        // 访问/responServlet会自动跳转到/responServlet2资源
        /*// 1. 设置状态码为302
        response.setStatus(302);
        // 2. 设置响应头location
        response.setHeader("location", "/responServlet2");*/

        // response.sendRedirect("/responServlet2");
        response.sendRedirect("http://www.clearlight.top");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
