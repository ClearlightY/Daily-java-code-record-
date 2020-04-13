package top.clearlight.jdbc.learn;

import top.clearlight.jdbc.utils.JDBCUtils;
import top.clearlight.jdbc.utils.JDBCUtils_sj;

import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.Scanner;

public class help_sj_JDBCTest {
    public static void main(String[] args) {
        //1.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        //2.调用方法
        boolean login = new help_sj_JDBCTest().login(username, password);
        //3.判断结果
        if(login){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
    public boolean login(String username,String password){
        if(username == null || password == null){
            return false;
        }
        //连接数据库判断是否登录成功
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //1.获取连接
        try {
            connection = JDBCUtils_sj.getConnection();
            //2.定义SQL
            String sql = "select * from stu where stu_username = '"+username+"' and stu_password = '"+password+"'";
            //3.获取执行SQL的对象
            statement = connection.createStatement();
            //4.执行查询
            resultSet = statement.executeQuery(sql);
            //5.判断
            return resultSet.next();//如果有下一行,则返回true
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,statement,connection);
        }
        return false;
    }
}
