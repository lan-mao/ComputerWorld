package top.lanmao.study202110.mybatisstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * Create Date 2021/10/27 18:24:55 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 包含student表的查询数据 <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class StudentQuery {
    private Long sid;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private Integer stuAge;
    private Timestamp createTime;
    private Timestamp updateTime;

    private Integer pageSize;
    /**
     * start是起始位置，从0开始，包含本位置数据，传入之前必须计算好。因为MySQL不允许在limit后面使用运算符
     */
    private Integer start;
}