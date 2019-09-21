package top.clearlight.jdbc.learn;

import java.sql.*;

/**
 * 数据库连接
 * 参考网址 :
 * [jdbc连接](https://blog.csdn.net/qiushi_1990/article/details/78570258)
 * [mysql：Java通过驱动包（jar包）连接MySQL数据库---步骤总结及验证](https://blog.csdn.net/m0_37482190/article/details/86497497)
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        // 这里是我的数据库test2
        String url = "jdbc:mysql://localhost:3306/test2";
        String user = "root";
        String password = "123456";

        try {
            // 加载驱动类
            Class.forName(driver);
            long start = System.currentTimeMillis();
            // 建立连接(连接对象内部其实包含了Socket对象,是一个远程连接.比较耗时!
            // 真正开发中,为了提高效率,都会使用连接池来管理连接对象!
            con = DriverManager.getConnection(url, user, password);
            long end = System.currentTimeMillis();

            System.out.println("建立连接耗时: " + (end - start) + "ms");

            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = con.createStatement();
            String sql = "select * from stu"; // 表格名称为stu
            ResultSet resultSet = statement.executeQuery(sql);
            String name;
            String age;
            while (resultSet.next()) {
                name = resultSet.getString("stu_name");
                age = resultSet.getString("stu_age");
                System.out.println("姓名: " + name +age);
            }

            String sql2 = "insert into stu (stu_name, stu_age, stu_date) values (\"Even\", 28, NOW())";
            int i = statement.executeUpdate(sql2);
            System.out.println("受影响的行数" + i);
            resultSet.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }
}
