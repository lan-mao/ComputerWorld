package top.lan_mao.computer_world.spring.dao;
/**
 * Create Date 2020/09/11 22:05
 * Created by lan-mao.top
 * TODO 
 *  - 基金账户操作接口
 */
 
public interface FundDao {
    /**
     * 开基金账户
     * @param fundName 基金名称
     * @param amount 基金金额
     */
    void insertFund(String fundName, int amount);

    /**
     * 更新基金账户数量
     * @param fundName 基金名称
     * @param amount 数量
     */
    void updateFund(String fundName, int amount);
}
