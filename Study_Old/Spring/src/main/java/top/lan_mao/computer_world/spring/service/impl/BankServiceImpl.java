package top.lan_mao.computer_world.spring.service.impl;

import org.springframework.transaction.annotation.Transactional;
import top.lan_mao.computer_world.spring.dao.AccountDao;
import top.lan_mao.computer_world.spring.dao.FundDao;
import top.lan_mao.computer_world.spring.exceptions.BankException;
import top.lan_mao.computer_world.spring.service.BankService;

/**
 * Create Date 2020/09/12 11:27
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class BankServiceImpl implements BankService {
    private FundDao fundDao;
    private AccountDao accountDao;

    public BankServiceImpl() {
    }

    public BankServiceImpl(FundDao fundDao, AccountDao accountDao) {
        this.fundDao = fundDao;
        this.accountDao = accountDao;
    }

    public FundDao getFundDao() {
        return fundDao;
    }

    public void setFundDao(FundDao fundDao) {
        this.fundDao = fundDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void openFund(String fundName, int count) {
        fundDao.insertFund(fundName, count);
    }

    @Override
    public void openAccount(String accountName, double balance) {
        accountDao.insertAccount(accountName, balance);
    }

    @Override
    @Transactional(rollbackFor = BankException.class)
    public void buyFund(String accountName, double balance, String fundName, int count) throws BankException {
        accountDao.updateAccount(accountName, balance);
        int random = (int) (Math.random()*10);
        System.out.println("->" + random);
        if (random > 1) {
            throw new BankException();
        }
        fundDao.updateFund(fundName,count);
    }
}