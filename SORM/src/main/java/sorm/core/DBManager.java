package sorm.core;

import sorm.bean.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * TODO 根据配置信息，维持连接对象的管理（连接池）
 *  - 增加连接池处理
 * @Date 2020/02/18 23:06
 * @Created by lan-mao.top
 */

public class DBManager {
    /**
     * 配置文件
     */
    private volatile static Configuration conf;
    /**
     * 连接池
     */
    private volatile static List<Connection> pool =  new ArrayList<>();
    /**
     * 连接池的最小数量
     */
    private static int POOL_MIN = 2;
    /**
     * 连接池的最大数量
     */
    private static int POOL_MAX = 100;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            conf = new Configuration();
            conf.setDriver(properties.getProperty("driver"));
            conf.setPoPackage(properties.getProperty("poPackage"));
            conf.setPwd(properties.getProperty("pwd"));
            conf.setSrcPath(properties.getProperty("srcPath"));
            conf.setClassPath(properties.getProperty("classPath"));
            conf.setUrl(properties.getProperty("url"));
            conf.setUser(properties.getProperty("user"));
            conf.setUsingDB(properties.getProperty("usingDB"));
            conf.setSchema(properties.getProperty("schema"));
            conf.setUsingQueryClass(properties.getProperty("usingQueryClass"));
            String poolMin =properties.getProperty("poolMin").trim();
            String poolMax =properties.getProperty("poolMax").trim();
            try {
                if (poolMax!=null){
                    conf.setPoolMax(Integer.parseInt(poolMax));
                    POOL_MAX = conf.getPoolMax();
                }
                if (poolMin!=null){
                    conf.setPoolMin(Integer.parseInt(poolMin));
                    POOL_MIN = conf.getPoolMin();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            initPool();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void initPool(){
        while (pool.size()<POOL_MIN) {
            pool.add(createConnection());
        }
    }
    public synchronized static Connection getConnection(){
        if (pool.size()<=POOL_MIN){
            pool.add(createConnection());
        }
        Connection conn = pool.get(pool.size()-1);
        pool.remove(pool.size()-1);
        return conn;
    }
    private static Connection createConnection(){
        try {
            Class.forName(conf.getDriver());
            return DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Configuration getConf() {
        return conf;
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                if (pool.size()<=POOL_MAX){
                    pool.add(connection);
                }else {
                    connection.close();
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement statement){
        close(connection, statement, null);
    }
    public static void close(Connection connection){
        close(connection, null);
    }
}
