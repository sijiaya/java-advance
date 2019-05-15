package com.soft1841.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 向数据表中新增一条数据
 * 5.16
 */
public class JDBCDemo2 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) throws SQLException ,ClassNotFoundException{
        //加载JDBC驱动
        Class.forName(JDBC_DRIVER);
        System.out.println("连接数据库......");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        //拼写SQL语句，用？作为参数占位符（姓名和年龄）;向数据库发送sql语句
        String sql = "INSERT INTO t_student(name,age) VALUES (?,?)";
        System.out.println("实例化一个PreparedStatement对象......");
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //向两个参数设置值
        pstmt.setString(1,"测试用户");
        pstmt.setInt(2,25);
        int n = pstmt.executeUpdate();
        System.out.println(n + "行受记录影响");
        //关闭连接
        pstmt.close();
        conn.close();
    }
}
