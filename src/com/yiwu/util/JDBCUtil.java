package com.yiwu.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    public static String driver;
    public static String url;
    public static String user;
    public static String passWord;
    public static ThreadLocal<Connection> tl = new ThreadLocal();

    static {
        Properties p = new Properties();
        try {
            p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            driver = p.getProperty("db.driver").trim();
            url = p.getProperty("db.url").trim();
            user = p.getProperty("db.user").trim();
            passWord = p.getProperty("db.password").trim();
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection  getConnection(){
        if (tl.get() != null) {
            return tl.get();
        }
        // 如果tl中没有连接, 创建一个连接, 存放到tl中
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passWord);
            // 将连接存入tl中
            tl.set(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("连接获取失败");
        }
        return conn;
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                // 关闭连接
                conn.close();
                // 删除tl中的连接
                tl.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void bindParam(PreparedStatement pstmt, Object... params) {
        try {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("参数绑定失败");
        }
    }
    public static PreparedStatement getPstmt(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("发送器创建失败");
        }
        return pstmt;
    }
}
