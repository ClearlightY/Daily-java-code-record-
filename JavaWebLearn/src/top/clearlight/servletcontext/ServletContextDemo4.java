package top.clearlight.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试ServletContext中域对象共享数据的功能 : 设置数据
 *
 * @author Clearlight
 */
@WebServlet("/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 2. 通过HttpServlet获取
        ServletContext servletContext1 = this.getServletContext();

        // 设置数据
        // Tips : 这里设置的数据如果不清除的话, 所有用户都可以访问该属性
        // 谨慎使用, 会对内存造成压力
        servletContext1.setAttribute("msg", "servletContextTransmit");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
