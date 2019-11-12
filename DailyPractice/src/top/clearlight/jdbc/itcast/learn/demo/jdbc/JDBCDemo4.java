package top.clearlight.jdbc.itcast.learn.demo.jdbc;

import top.clearlight.jdbc.itcast.learn.demo.domain.Stu;
import top.clearlight.jdbc.itcast.learn.demo.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法, 查询user表的数据将其封装为对象, 然后装载集合, 返回
 */
public class JDBCDemo4 {

    public static void main(String[] args) {
        JDBCDemo4 jdbc = new JDBCDemo4();
        List<Stu> stuList = jdbc.findAll2();
        System.out.println(stuList);
    }

    /**
     * 查询所有user对象
     *
     * @return
     */
    public List<Stu> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Stu> list = new ArrayList<>();
        // 1. 注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///user", "root", "root");
            // 3. 定义sql
            String sql = "select * from stu";
            // 4. 获取执行sql的对象
            stmt = conn.createStatement();
            // 5.执行sql
            rs = stmt.executeQuery(sql);
            // 6.遍历结果集, 封装对象, 装载集合
            Stu stu = null;
            while (rs.next()) {
                stu = new Stu();
                // 获取数据
                int id = rs.getInt("stu_id");
                String stu_username = rs.getString("stu_username");
                int stu_password = rs.getInt("stu_password");
                int stu_weight = rs.getInt("stu_weight");
                stu.setId(id);
                stu.setStu_username(stu_username);
                stu.setStu_password(stu_password);
                stu.setStu_weight(stu_weight);
                list.add(stu);
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
        return list;
    }

    /**
     * 演示JDBC工具类
     */
    /**
     * 查询所有user对象
     *
     * @return
     */
    public List<Stu> findAll2() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Stu> list = new ArrayList<>();
        // 1. 注册驱动
        try {
            conn = JDBCUtils.getConnection();
            // 3. 定义sql
            String sql = "select * from stu";
            // 4. 获取执行sql的对象
            stmt = conn.createStatement();
            // 5.执行sql
            rs = stmt.executeQuery(sql);
            // 6.遍历结果集, 封装对象, 装载集合
            Stu stu = null;
            while (rs.next()) {
                stu = new Stu();
                // 获取数据
                int id = rs.getInt("stu_id");
                String stu_username = rs.getString("stu_username");
                int stu_password = rs.getInt("stu_password");
                int stu_weight = rs.getInt("stu_weight");
                stu.setId(id);
                stu.setStu_username(stu_username);
                stu.setStu_password(stu_password);
                stu.setStu_weight(stu_weight);
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return list;
    }

}
