package top.clearlight.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试ServletContext中MIME功能
 *
 * @author Clearlight
 */
@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 2. 通过HttpServlet获取
        ServletContext servletContext1 = this.getServletContext();

        // 3. 定义文件名称
        String fileName = "a.zip";
        // 4. 获取MIME类型
        String mimeType = servletContext1.getMimeType(fileName);
        // 将打印 : application/zip
        System.out.println(mimeType);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
