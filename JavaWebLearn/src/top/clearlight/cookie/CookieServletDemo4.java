package top.clearlight.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieServletDemo4")
public class CookieServletDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 创建Cookie对象
        Cookie cookie = new Cookie("msg", "setMaxAge");
        // 2. 设置Cookie存活时间
        // 将Cookie持久化到硬盘, 30秒后会自动删除Cookie文件
        cookie.setMaxAge(30);
        // 默认值, 关闭浏览器, 则清空cookie
        cookie.setMaxAge(-1);
        // 删除存储的物理文件
        cookie.setMaxAge(0);

        // 3. 发送Cookie
        response.addCookie(cookie);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
