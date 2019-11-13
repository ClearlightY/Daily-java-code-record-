package top.clearlight.jdbc.druid;

import top.clearlight.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo3 {

    public static void main(String[] args) {
        /**
         * 完成添加操作, 给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1. 获取连接
            conn = JDBCUtils.getConnection();
            // 2. 定义sql
            String sql = "insert into stu value(null, ?, ?, ?)";
            // 3. 获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            // 4. 给?赋值
            pstmt.setString(1, "Rookie");
            pstmt.setInt(2, 109);
            pstmt.setInt(3, 71);
            // 5. 执行sql
            int count = pstmt.executeUpdate();
            // 6. 返回结果集
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }

}
