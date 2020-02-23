package sorm.core;

import sorm.bean.ColumnInfo;
import sorm.bean.TableInfo;
import sorm.util.JDBCUtils;
import sorm.util.ReflectUtils;
import sorm.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  负责增删查改（对外提供服务核心类）
 *
 * @Date 2020/02/18 22:42
 * @Created by lan-mao.top
 */
public abstract class Query {
    /**
     * 直接执行一个SQL语句
     * @param sql sql语句
     * @param params 参数
     * @return 执行sql语句后影响的行数
     */
    public int executeDML(String sql, List<Object> params){
        Connection conn = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        int execute = 0;
        try {
            preparedStatement = JDBCUtils.getPreparedStatement(conn, sql, params.toArray());
            execute = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, preparedStatement);
        }
        return execute;
    }

    /**
     * 将一个对象存储到数据库中
     * 把对象中不为null的属性存入数据库。
     * @param obj 要存的对象
     * @return 返回布尔值，是否插入成功
     */
    public boolean insert(Object obj){
        Class clazz = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz.getName());
        String tableName = tableInfo.getName();
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("values(");
        Field[] fields = clazz.getDeclaredFields();
        List<Object> valueList = new ArrayList<>();
        for (Field field : fields) {
            String columnName = field.getName();
            Object value = ReflectUtils.invokeGet(columnName, obj);
            if (value!=null){
                columns.append(StringUtils.covertFromJavaCamelCase(columnName) + ",");
                values.append("?,");
                valueList.add(value);
            }
        }
        columns.replace(columns.lastIndexOf(","),columns.length(),")");
        values.replace(values.lastIndexOf(","),values.length(),")");
        String sql = String.format("insert into %s%s %s;",tableName, columns, values);
        return executeDML(sql, valueList) == 1;
    }

    /**
     * 删除对象对应的数据库信息
     * @param obj 要删除的那条记录
     * @return 返回布尔值，是否删除成功
     */
    public boolean delete(Object obj){
        Class clazz = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz.getName());
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
        Object value = ReflectUtils.invokeGet(onlyPriKey.getName(),obj);
        return delete(clazz, value);
    }

    /**
     * 删除一个clazz表示的类的对应的表中的记录（指定主键为id的记录）
     * @param clazz 跟表对应的Class对象
     * @param value 主键值
     * @return 返回布尔值，是否删除成功
     */
    public boolean delete(Class clazz, Object value){
        //delete from emp where id = 2
        String className = clazz.getName();
        TableInfo tableInfo = TableContext.poClassTableMap.get(className);
        String sql = String.format("delete from %s where %s = ?", tableInfo.getName(), tableInfo.getOnlyPriKey().getName());
        return executeDML(sql, Arrays.asList(value)) == 1;
    }

    /**
     * 更新对象对应的数据库中的对应行，并且只更新指定字段的值
     * @param obj 所更新的对象
     * @param fieldNames 要更新的字段(以Java文件中名称为准)
     * @return 返回布尔值，是否更新成功
     */
    public boolean update(Object obj, String[] fieldNames){
        // update table_name set **=?,**=? where ***=?;
        Class clazz = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz.getName());
        String tableName = tableInfo.getName();
        List<Object> valueList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("update " + tableName +" set ");
        for (String fieldName : fieldNames) {
            sql.append(StringUtils.covertFromJavaCamelCase(fieldName) + "=?, ");
            Object value = ReflectUtils.invokeGet(fieldName, obj);
            valueList.add(value);
        }
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
        sql.replace(sql.lastIndexOf(", "), sql.length(), " where ").append(onlyPriKey.getName()).append("=? ");
        Object value = ReflectUtils.invokeGet(StringUtils.toUpperCamelCase(onlyPriKey.getName()), obj);
        valueList.add(value);
        return executeDML(sql.toString(), valueList) == 1;
    }

    /**
     * 查询返回一条记录，并将每条记录封装到clazz指定的类的对象中
     * @param sql 查询语句
     * @param clazz 封装数据的Javabean的Class对象
     * @param params sql语句的指定参数
     * @return 查询的结果
     */
    public Object queryUniqueRows(String sql,Class clazz, Object[] params){
        List list = queryRows(sql, clazz, params);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    /**
     * 查询返回多条记录，并将每条记录封装到clazz指定的类的对象中
     * @param sql 查询语句
     * @param clazz 封装数据的Javabean的Class对象
     * @param params sql语句的指定参数
     * @return 查询的结果
     */
    public List queryRows(String sql,Class clazz, Object[] params){
        return (List)executeQueryTemplate(sql, clazz, params, (conn, preparedStatement, resultSet, clazz2)->{
            List rowList = new ArrayList();
            try {
                while (resultSet.next()) {
                    Object obj = JDBCUtils.getResultValue(clazz2, resultSet);
                    rowList.add(obj);
                }
                return rowList;
            } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
    /**
     * 查询返回一个数字（一行一列），并将每条记录封装到clazz指定的类的对象中
     * @param sql 查询语句
     * @param params sql语句的指定参数
     * @return 查询的结果
     */
    public Number queryNumber(String sql, Object[] params){
        Object value = queryValue(sql, params);
        return (value != null && value instanceof Number) ? (Number) value : null;
    }
    /**
     * 查询返回一个值（一行一列），并将每条记录封装到clazz指定的类的对象中
     * @param sql 查询语句
     * @param params sql语句的指定参数
     * @return 查询的结果
     */
    public Object queryValue(String sql, Object[] params) {
        return executeQueryTemplate(sql, null, params, (conn,preparedStatement, resultSet, clazz)->{
            Object value = null;
            try {
                while (resultSet.next()) {
                    value = resultSet.getObject(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return value;
        });
    }

    /**
     * 查询语句的模板方法，使用查询的时候可以直接调用这个类，然后传入一个Callback类，在Callback类中写对查询结果集处理的具体方法
     * @param sql 要执行的查询语句
     * @param clazz 查询结果封装的JavaBean类
     * @param params 查询语句中需要传的参数
     * @return
     */
    private Object executeQueryTemplate(String sql,Class clazz, Object[] params, Callback callback){
        Connection conn = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = JDBCUtils.getPreparedStatement(conn, sql, params);
            resultSet = preparedStatement.executeQuery();
            return callback.doExecute(conn, preparedStatement, resultSet, clazz);
        } catch (SQLException  e) {
            e.printStackTrace();
            return null;
        } finally {
            DBManager.close(conn, preparedStatement,resultSet);
        }
    }

    /**
     * 分页查询
     * @param pageNum 第几页
     * @param size 每页大小
     * @return
     */
    public abstract Object queryPaging(int pageNum, int size);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

interface Callback{
    Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs, Class clazz);
}