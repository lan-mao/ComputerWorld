package top.lan_mao.computer_world.spring.pojo;
/**
 * Create Date 2020/09/11 17:37
 * Created by lan-mao.top
 * TODO 
 *  - 基金类
 */

//基金类
public class Fund {
    private Integer fundId;
    private String fundName;
    private Integer count;

    public Fund() {
    }

    public Fund(String fundName, Integer count) {
        this.fundName = fundName;
        this.count = count;
    }

    public Fund(Integer fundId, String fundName, Integer count) {
        this.fundId = fundId;
        this.fundName = fundName;
        this.count = count;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Fund{");
        sb.append("fundId=").append(fundId);
        sb.append(", fundName='").append(fundName).append('\'');
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
