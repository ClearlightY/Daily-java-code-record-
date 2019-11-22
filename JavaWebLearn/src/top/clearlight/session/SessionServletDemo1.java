package top.clearlight.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionServletDemo1")
public class SessionServletDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取HttpSession对象
        HttpSession session = request.getSession();

        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60 * 2);
        response.addCookie(c);

        // 2. 设置Session
        session.setAttribute("msg", "session_test");
        System.out.println(session);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
