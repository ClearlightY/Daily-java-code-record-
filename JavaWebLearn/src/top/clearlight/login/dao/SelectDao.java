package top.clearlight.login.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import top.clearlight.login.domain.Student;
import top.clearlight.login.util.JDBCUtils;

import java.util.Map;

public class SelectDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void select(Student student) {
        String username = student.getUsername();
        String password = student.getPassword();

        String sql = "select * from student where username = ? and password = ?";
        Map<String, Object> map = template.queryForMap(sql, username, password);
        System.out.println(map);
    }

    public static void main(String[] args) {
        new SelectDao().select(new Student("jack", "123"));
    }
}
