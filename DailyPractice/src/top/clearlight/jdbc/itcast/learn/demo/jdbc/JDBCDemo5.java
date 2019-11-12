package top.clearlight.jdbc.itcast.learn.demo.jdbc;

import top.clearlight.jdbc.itcast.learn.demo.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 需求:
 * 1. 通过键盘录入用户名和密码
 * 2. 判断用户是否登录成功
 */
public class JDBCDemo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();

        JDBCDemo5.judgeLogin(username, password);


    }

    public static void judgeLogin(String username, String password) {

        if (username == null || password == null) {
            return;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            // 提交事务
            conn.setAutoCommit(false);
            // Para conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("select * from user where username= ? and password= ?");
            ps.setObject(1, username);
            ps.setObject(2, password);

            rs = ps.executeQuery();

            // 提交事务
            conn.commit();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("id");
                System.out.println(id);
            }
            if (id > 0) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            // 回滚事务
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
    }

    /*public static void judgeLogin(String username, String password) {

        Connection conn = JDBCUtils.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from user where username='" + username + "' and password='" + password + "';";
        System.out.println(sql);
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            if (id > 0) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
    }*/


}
