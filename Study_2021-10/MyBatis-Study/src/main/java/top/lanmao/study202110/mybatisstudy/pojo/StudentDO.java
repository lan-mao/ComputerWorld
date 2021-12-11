package top.lanmao.study202110.mybatisstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * Create Date 2021/10/03 9:36:34 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentDO {
    private Long sid;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private Integer stuAge;
    private Timestamp createTime;
    private Timestamp updateTime;
}