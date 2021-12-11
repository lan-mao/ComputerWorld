package top.lanmao.computer_world.spring.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.lanmao.computer_world.spring.dao.AccountDao;

import java.util.Objects;

/**
 * Create Date 2020/09/11 22:10
 * Created by lan-mao.top
 */

//如果使Spring实现对jdbc的支持，需要继承类JdbcDaoSupport
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void insertAccount(String accountName, double money) {
        String sql = "insert into spring_jdbc_test.account(account_name,account_balance) values(?,?);";
        assert this.getJdbcTemplate() != null;
        this.getJdbcTemplate().update(sql, accountName, money);
    }

    @Override
    public void updateAccount(String accountName, double money) {
        String sql = "update spring_jdbc_test.account set account_balance=account.account_balance-? where account_name=?";
        Objects.requireNonNull(this.getJdbcTemplate()).update(sql, money, accountName);
    }
}