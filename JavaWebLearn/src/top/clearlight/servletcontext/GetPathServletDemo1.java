package top.clearlight.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getPathServletDemo1")
public class GetPathServletDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 通过HttpServlet获取ServletContext对象
        ServletContext context = this.getServletContext();

        // 2. 获取文件的服务器路径
        // 2.1 获取web目录下的文件绝对路径
        String realPath = context.getRealPath("b.txt");
        System.out.println(realPath);

        // 2.2 获取src目录下的文件绝对路径
        String realPath1 = context.getRealPath("/WEB-INF/clases/a.txt");
        System.out.println(realPath1);

        // 2.3 获取WEB-INF目录下的文件绝对路径
        String realPath2 = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
