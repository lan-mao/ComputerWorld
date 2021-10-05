package top.lan_mao.computer_world.spring.pojo;
/**
 * Create Date 2020/09/11 17:28
 * Created by lan-mao.top
 *  - 账户实体类
 */

//账户类
public class Account {
    private Integer accountId;
    private String accountName;
    private Double accountBalance;

    public Account() {
    }

    public Account(String accountName, Double accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public Account(Integer accountId, String accountName, Double accountBalance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("accountId=").append(accountId);
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", accountBalance=").append(accountBalance);
        sb.append('}');
        return sb.toString();
    }
}