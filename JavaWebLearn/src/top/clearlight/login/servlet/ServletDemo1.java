package top.clearlight.login.servlet;

import org.apache.commons.beanutils.BeanUtils;
import top.clearlight.login.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置编码
        request.setCharacterEncoding("utf-8");
       /* // 2. 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 封装stu对象
        new SelectDao().select(new Student(username, password));*/


       /*
            通过BeanUtils工具来设置实体
        */
        // 创建User对象
        Student stu = new Student();
        // 获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        // 使用BeanUtils工具来设置实体
        try {
            BeanUtils.populate(stu, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        System.out.println(stu.getUsername() + ":" + stu.getPassword());


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
