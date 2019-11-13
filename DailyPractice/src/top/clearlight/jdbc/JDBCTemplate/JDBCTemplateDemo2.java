package top.clearlight.jdbc.JDBCTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import top.clearlight.jdbc.domain.Stu;
import top.clearlight.jdbc.utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Spring JDBC 练习
 */
public class JDBCTemplateDemo2 {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void updateTest() {
        String sql = "update stu set stu_weight = ? where stu_id = ? or stu_id = ?";
        int count = template.update(sql, 65, 7, 8);
        System.out.println(count);
    }

    @Test
    public void addTest() {
        String sql = "insert into stu value (null, ?, ?, ?)";
        int count = template.update(sql, "Peak", 888, 54);
        System.out.println(count);
    }

    @Test
    public void delTest() {
        String sql = "delete from stu where stu_id = ?";
        int count = template.update(sql, 15);
        System.out.println(count);
    }

    @Test
    public void selectTest() {
        String sql = "select stu_username from stu where stu_id = ?";
        Map<String, Object> stringObjectMap = template.queryForMap(sql, 14);
        System.out.println(stringObjectMap);
    }

    @Test
    public void selectAllTest() {
        String sql = "select * from stu";
        List<Map<String, Object>> lists = template.queryForList(sql);

        for (Map<String, Object> list : lists) {
            // System.out.println(list);
            Set<String> keySet = list.keySet();
            Iterator<String> iter = keySet.iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                Object o = list.get(key);
                System.out.println(key + ": " + o);
            }
        }
    }

    @Test
    public void pottingTest() {
        String sql = "select * from stu";
        List<Stu> query = template.query(sql, new RowMapper<Stu>() {
            @Override
            public Stu mapRow(ResultSet rs, int i) throws SQLException {
                return new Stu(rs.getInt("stu_id"), rs.getString("stu_username"),
                        rs.getInt("stu_password"), rs.getInt("stu_weight"));
            }
        });

        for (Stu stu : query) {
            System.out.println(stu);
        }
    }

    @Test
    public void test2() {
        String sql = "select * from stu";
        List<Stu> list = template.query(sql, new BeanPropertyRowMapper<>(Stu.class));
        for (Stu stu : list) {
            System.out.println(stu);
        }
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test3() {
        String sql = "select count(stu_id) from stu";
        Integer total = template.queryForObject(sql, Integer.class);
        System.out.println(total);
    }

}
