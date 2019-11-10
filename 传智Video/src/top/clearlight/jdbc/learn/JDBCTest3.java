package top.clearlight.jdbc.learn;

import java.sql.*;

/**
 * ResultSet结果集测试
 */
public class  JDBCTest3 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String driver = "com.mysql.jdbc.Driver";
        // 这里是我的数据库test2
        String url = "jdbc:mysql://localhost:3306/test2";
        String user = "root";
        String password = "123456";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            String sql = "select stu_name, stu_age from stu where stu_age < ?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, 20);

            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("stu_name") + "---" + resultSet.getString("stu_age"));
            }
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
            if (ps != null) {
                try {
                    ps.close();
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
