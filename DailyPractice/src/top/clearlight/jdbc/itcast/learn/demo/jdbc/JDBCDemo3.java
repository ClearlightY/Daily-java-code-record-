package top.clearlight.jdbc.itcast.learn.demo.jdbc;

import java.sql.*;

public class JDBCDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///user", "root", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from stu");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("stu_username");
                int pwd = rs.getInt(3);
                int weight = rs.getInt("stu_weight");
                System.out.println(id + "---" + name + "---" + pwd + "---" + weight);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
