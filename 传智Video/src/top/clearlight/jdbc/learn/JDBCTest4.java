package top.clearlight.jdbc.learn;

import java.sql.*;

/**
 * 批处理Batch测试
 */
public class JDBCTest4 {
    public static void main(String[] args) {
        Connection con = null;
        Statement sm = null;
        ResultSet resultSet = null;
        String driver = "com.mysql.jdbc.Driver";
        // 这里是我的数据库test2
        String url = "jdbc:mysql://localhost:3306/test2";
        String user = "root";
        String password = "123456";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            // 设为手动提交
            con.setAutoCommit(false);
            long start = System.currentTimeMillis();
            sm = con.createStatement();

            for (int i = 0; i < 20000; i++) {
                sm.addBatch("insert into user (user_name, user_age, user_date) value ('peo"+i+"', 18, now())");
            }
            sm.executeBatch();
            con.commit(); // 提交事物
            long end = System.currentTimeMillis();
            System.out.println("插入20000条数据耗时: " + (end - start) + "ms");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 遵循:ResultSet -> Statement -> Connection 的顺序关闭,切要将灿哥trycatch块分开写!
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (sm != null) {
                try {
                    sm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
