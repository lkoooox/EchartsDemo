package com.yiwu.dao;

import com.yiwu.util.JDBCUtil;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {

    /**
     * 统计数量的方法
     *
     * @param sql
     * @param params
     * @return
     */
    public int count(String sql, Object... params) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = JDBCUtil.getPstmt(conn, sql);
        JDBCUtil.bindParam(pstmt, params);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return 0;
    }

    /**
     * 查询单个数据的统一方法
     *
     * @param cls    - 要查询的对象的Class类型
     * @param sql    - 要执行的sql语句
     * @param params - sql语句要绑定的参数
     * @return
     */
    public <E> E queryOne(Class<E> cls, String sql, Object... params) {
        List<E> list = queryList(cls, sql, params);
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 查询多条数据的统一方法
     *
     * @param cls    - 要查询的对象的Class类型
     * @param sql    - 要执行的sql语句
     * @param params - sql语句要绑定的参数
     * @return
     */
    public <E> List<E> queryList(Class<E> cls, String sql, Object... params) {
        List<E> list = new ArrayList<>();

        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = JDBCUtil.getPstmt(conn, sql);
        JDBCUtil.bindParam(pstmt, params);
        ResultSet rs = null;

        try {
            rs = pstmt.executeQuery();
            // 获取数据库表格元数据
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                // 通过反射创建对象
                E bean = cls.newInstance();
                // 为对象的属性赋值, 有几列就调用几次set方法
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    // 一列一列的获取
                    String columnLabel = metaData.getColumnLabel(i);
                    // 通过反射获取属性的类型
                    Class<?> type = cls.getDeclaredField(columnLabel).getType();
                    // 基于属性拼接set方法 empno --> setEmpno
                    String setMethodName = "set" + columnLabel.substring(0, 1).toUpperCase() +
                            columnLabel.substring(1);
                    // 通过反射获取set方法
                    Method method = cls.getMethod(setMethodName, type);
                    // 调用set方法为属性赋值
                    method.invoke(bean, rs.getObject(columnLabel));
                }
                // 将对象加入list集合
                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }

        return list;
    }

    /**
     * 执行DML操作的统一方法
     *
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql, Object... params) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = JDBCUtil.getPstmt(conn, sql);
        JDBCUtil.bindParam(pstmt, params);
        try {
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, pstmt, conn);
        }
        return 0;
    }
}
