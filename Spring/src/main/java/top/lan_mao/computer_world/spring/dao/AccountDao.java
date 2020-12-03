package top.lan_mao.computer_world.spring.dao;
/**
 * Create Date 2020/09/11 22:02
 * Created by lan-mao.top
 * TODO 
 *  - 银行账户的操作接口
 */
 
public interface AccountDao {
    /**
     * 开银行账户
     */
    void insertAccount(String accountName, double money);

    /**
     * 更新银行余额
     */
    void updateAccount(String accountName, double money);

    default void add() {
        int a =0;
    }
    default void insert() {
        int a =0;
    }
}
