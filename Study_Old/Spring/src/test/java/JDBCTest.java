import org.junit.Test;

import java.sql.*;

/**
 * Create Date 2020/09/12 16:34
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class JDBCTest {
    @Test
    public void jdbcTest01() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_jdbc_test","root", "test");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select user.Host,user.User from mysql.user ;");
        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println(metaData.getColumnCount());
        conn.close();
    }
}
