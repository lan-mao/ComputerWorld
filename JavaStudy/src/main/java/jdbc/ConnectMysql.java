package jdbc;

import java.sql.*;

/**
 *  使用JDBC连接Mysql
 *
 * @date  2020/02/17 19:40
 * @author by lan-mao.top
 */

public class ConnectMysql {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.100:3306/xiaohaizi","root","test" );
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("insert into test_jdbc(name,create_date) values(?,?);");
            for (int i = 0; i < 2000000; i++) {
                preparedStatement.setString(1, "qaq"+i);
                preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            conn.commit();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}