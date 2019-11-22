package top.clearlight.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SessionServletDemo2")
public class SessionServletDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取HttpSession对象
        HttpSession session = request.getSession();
        // 2. 获取Session
        Object msg = session.getAttribute("msg");
        // 打印Session的值
        System.out.println(msg);
        System.out.println(session);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
