package top.clearlight.jdbc.JDBCTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import top.clearlight.jdbc.utils.JDBCUtils;

/**
 * JDBC Template 入门
 */
public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        // 1. 导入jar包
        // 2. 创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        // 3. 调用方法
        String sql = "update stu set stu_password=110 where stu_id = ?";
        int count = template.update(sql, 14);
        System.out.println(count);
    }
}
