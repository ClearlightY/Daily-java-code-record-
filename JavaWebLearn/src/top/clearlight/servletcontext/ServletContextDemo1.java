package top.clearlight.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取ServletContext对象
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 通过request对象获取
        ServletContext servletContext = request.getServletContext();

        // 2. 通过HttpServlet获取
        ServletContext servletContext1 = this.getServletContext();

        System.out.println(servletContext);
        System.out.println(servletContext1);

        // true, 两种获取的对象相同
        System.out.println(servletContext == servletContext1);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
