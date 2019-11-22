package top.clearlight.login.servlet;

import org.apache.commons.beanutils.BeanUtils;
import top.clearlight.login.dao.SelectDao;
import top.clearlight.login.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 使用JDBC与Session来实现登录与验证码的逻辑
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置request编码
        request.setCharacterEncoding("utf-8");
        // 2. 获取参数
        String checkCode = request.getParameter("checkCode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Student stu = new Student(username, password);

      /*  Student stu = new Student();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(stu, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String username = stu.getUsername();
        String password = stu.getPassword();*/


        // 3. 获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        // 删除Session中存储的验证码
        // 验证成功后, 后退时, 将清空已记录的session, 让session只生效一次
        session.removeAttribute("checkCode_session");

        // 3. 判断验证码是否正确
        // 忽略大小写比较
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            // 判断用户名和密码是否一致
            // 需要调用UserDao查询数据库
            if (new SelectDao().select(stu) > 0) {
                // 登录成功
                // 存储用户信息
                session.setAttribute("user", username);
                // 重定向到success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                // 登录失败
                // 存储信息到request
                System.out.println(username + "-" + password);
                request.setAttribute("login_error", "用户名或密码错误");
                // 转发到登录页面
                request.getRequestDispatcher("/CompleteLogin.jsp").forward(request, response);
            }
        } else {
            // 验证码不一致
            // 存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/CompleteLogin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
