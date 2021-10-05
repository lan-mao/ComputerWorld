import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lan_mao.computer_world.spring.exceptions.BankException;
import top.lan_mao.computer_world.spring.service.BankService;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create Date 2020/09/12 11:38
 * Created by lan-mao.top
 */

public class TransactionTest {

    public BankService bankService;
    ApplicationContext context;
    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("applicationContext-transaction.xml");
        bankService = context.getBean("bankService", BankService.class);
    }
    @Test
    public void openAccount() {
        bankService.openAccount("工商银行",1000293);
    }
    @Test
    public void openFund() {
        bankService.openFund("养老宝",100);
    }

    @Test
    public void buyFund() throws BankException {
        bankService.buyFund("工商银行", 2000, "养老宝",200);
    }

    @Test
    public void c3p0Test() throws SQLException, PropertyVetoException {
        ComboPooledDataSource dataSource = context.getBean("dataSource", ComboPooledDataSource.class);
        //ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        //dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/");
        //dataSource.setUser("root");
        //dataSource.setPassword("test");
        System.out.println(dataSource.getUser());
        System.out.println(dataSource.getJdbcUrl());
        System.out.println(dataSource.getDriverClass());
        System.out.println(dataSource.getPassword());
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from mysql.user;");
        resultSet.last();
        System.out.println(resultSet.getRow());
    }
}