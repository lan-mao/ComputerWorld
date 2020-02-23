package sorm.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/**
 * TODO 封装常用的JDBC操作
 *
 * @Date 2020/02/18 23:07
 * @Created by lan-mao.top
 */

public class JDBCUtils {
    /**
     * 获取一个已经注入参数的PreparedStatement类
     * @param conn 与数据库的链接
     * @param sql 预编译语句
     * @param params 参数
     * @return 注入参数的PrepareStatement
     * @throws SQLException
     */
    public static PreparedStatement getPreparedStatement(Connection conn, String sql, Object[] params) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1, params[i]);
        }
        System.out.println(new java.util.Date().toString() +"----->" + preparedStatement.toString());
        return preparedStatement;
    }

    /**
     * 使用反射，将查询到的结果返回为对象
     * @param clazz 要返回的对应类的class对象
     * @param resultSet 查询的结果集
     * @return Object对象
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SQLException
     */
    public static Object getResultValue(Class clazz, ResultSet resultSet) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SQLException {
        Object obj = clazz.getConstructor().newInstance();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            String columnName = metaData.getColumnLabel(i+1);
            Object value = resultSet.getObject(i+1);
            if (value!=null){
                ReflectUtils.invokeSet(columnName, obj, value);
            }
        }
        return obj;
    }
}
