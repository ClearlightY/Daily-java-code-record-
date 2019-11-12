package top.clearlight.jdbc.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0演示
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        // 1. 获取DataSource
        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接
        for (int i = 0; i < 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);

            if (i == 5) {
                // 归还连接到连接池中
                conn.close();
            }
        }
    }

    @Test
    public  void test() throws SQLException {
        // 1. 测试指定的配置内容
        DataSource ds = new ComboPooledDataSource("test");
        // 2. 获取连接
        for (int i = 0; i < 10; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i + ":" + connection);
        }
    }
}
