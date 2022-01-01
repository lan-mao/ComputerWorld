package top.lanmao.computer_world.spring.service;

import top.lanmao.computer_world.spring.exceptions.BankException;

/**
 * Create Date 2020/09/12 11:22
 * Created by lan-mao.top
 *  -
 */

public interface BankService {
    void openFund(String fundName, int count);
    void openAccount (String accountName, double balance);
    void buyFund(String accountName, double balance,String fundName, int count) throws BankException;
}