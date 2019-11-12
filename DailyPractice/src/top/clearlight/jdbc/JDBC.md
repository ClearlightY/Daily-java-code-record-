# JDBC常用接口
---
- Statement接口

    1. 用于执行静态SQl语句并返回它所生成结果的对象

    2. 三种Statement类:
        - Statement: 由createStatement创建,用于发送简单的SQL语句(不带参数的)
            1. boolean execute(String sql) : 可以执行任意的sql
            2. int `executeUpdate`(String sql) : 执行DML(insert, update, delete)语句,DDL(create,alter,drop)语句
            3. ResultSet `executeQuery`(String sql) : 执行DQL(select)语句
        - PreparedStatement: 由prepareStatement创建,用于发送含有一个或多个输入参数的sql语句.并且效率更高,还可以防止sql注入.
        - CallableStatement: 继承自PreparedStatement. 由方法prepareCall创建,用于调用存储过程.
        
    3. 常用的Statement方法:
        - execute(): 运行语句,返回是否有结果集
        - executeQuery(): 运行select语句,返回ResultSet结果集
        - executeUpdate(): 运行insert/update/delete操作,返回更新的行数
        
        
- ResultSet接口
    > 返回结果集对象, 封装查询结果

    1. Statement执行SQL语句时返回ResultSet结果集

    2. ResultSet提供的检索不同类型字段的方法,常用的有:
        next() : 游标向下移动一行
        getXXX(参数) : 获取数据
            - getString(): 获得在数据库中是varchar、char等数据类型的对象
            - getFloat(): 获得在数据库中是Float类型的对象
            - getDate(): 获得在数据库中是Date类型的数据
            - getBoolean(): 获得在数据库中是Boolean类型的数据
        参数 :
            1. int : 代表查询列的编号, 从1开始
            2. String : 代表查询列的名称. 如 : getInt("stu_password")

         循环判断游标是否是最后一行末尾
         while (rs.next()) {
            // 获取数据
            int id = rs.getInt(1);
            String name = rs.getString("stu_username");
         }
        
- 依次关闭使用对象及连接:
    
    ResultSet -> Statement -> Connection


包名
domain : 存放实体类, 用来封装数据

util : 存放工具类, 将公共方法抽取到工具类中

# JDBC工具类
---
```java
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取, 只需要读取一次即可拿到这些值, 使用静态代码块
     */
    static {
        try {
            // 读取资源文件, 获取值
            // 1. 创建Properties集合类
            Properties pro = new Properties();

            // 获取jdbc路径下的文件的方式 --> ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            // 解决路径乱码问题
            String decode = URLDecoder.decode(path, "UTF-8");
            // 2. 加载文件
            pro.load(new FileReader(path));

            // 3. 获取数据, 赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            // 4. 注册驱动
            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
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

    public static void close(Statement stmt, Connection conn) {
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
                e.printstacktrace();
            }
        }
    }
}
```

JDBC的工具类使用
```java
public static void judgeLogin(String username, String password) {

        if (username == null || password == null) {
            return;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            // Para conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("select * from user where username= ? and password= ?");
            ps.setObject(1, username);
            ps.setObject(2, password);

            rs = ps.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
    }
```