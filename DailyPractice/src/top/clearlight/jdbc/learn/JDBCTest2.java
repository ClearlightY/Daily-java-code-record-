package top.clearlight.jdbc.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement类测试
 */
public class JDBCTest2 {
    public static void main(String[] args) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        // 这里是我的数据库test2
        String url = "jdbc:mysql://localhost:3306/test2";
        String user = "root";
        String password = "123456";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            String sql = "insert into stu (stu_name, stu_age, stu_date) values (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, "Tom");
            ps.setObject(2, 19);
            ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
            ps.execute();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
