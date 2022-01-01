package top.lanmao.computer_world.spring.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.lanmao.computer_world.spring.dao.FundDao;

import java.util.Objects;

/**
 * Create Date 2020/09/12 9:06
 * Created by lan-mao.top
 */

public class FundDaoImpl extends JdbcDaoSupport implements FundDao {
    @Override
    public void insertFund(String fundName, int amount) {
        String sql = "insert spring_jdbc_test.fund (fund.fund_name,fund.count) values (?,?)";
        Objects.requireNonNull(this.getJdbcTemplate()).update(sql, fundName, amount);
    }

    @Override
    public void updateFund(String fundName, int amount) {
        String sql = "update spring_jdbc_test.fund set fund.count = fund.count+? where fund.fund_name = ?";
        Objects.requireNonNull(this.getJdbcTemplate()).update(sql, amount, fundName);
    }
}