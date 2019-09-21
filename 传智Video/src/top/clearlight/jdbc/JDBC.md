# JDBC常用接口
---
- Statement接口

    1. 用于执行静态SQl语句并返回它所生成结果的对象

    2. 三种Statement类:
        - Statement: 由createStatement创建,用于发送简单的SQL语句(不带参数的)
        - PreparedStatement: 由prepareStatement创建,用于发送含有一个或多个输入参数的sql语句.并且效率更高,还可以防止sql注入.
        - CallableStatement: 继承自PreparedStatement. 由方法prepareCall创建,用于调用存储过程.
        
    3. 常用的Statement方法:
        - execute(): 运行语句,返回是否有结果集
        - executeQuery(): 运行select语句,返回ResultSet结果集
        - executeUpdate(): 运行insert/update/delete操作,返回更新的行数
        
        
- ResultSet接口
    1. Statement执行SQL语句时返回ResultSet结果集
    2. ResultSet提供的检索不同类型字段的方法,常用的有:
        - getString(): 获得在数据库中是varchar、char等数据类型的对象
        - getFloat(): 获得在数据库中是Float类型的对象
        - getDate(): 获得在数据库中是Date类型的数据
        - getBoolean(): 获得在数据库中是Boolean类型的书上
        
- 依次关闭使用对象及连接:
    
    ResultSet -> Statement -> Connection