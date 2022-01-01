package top.lanmao.study202110.mybatisstudy2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * Create Date 2021/11/05 8:48:28 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Students {
    private String sId;
    private String sName;
    private Integer sAge;
    private Long sCid;
    private Timestamp createTime;
    private Timestamp updateTime;

    private Classes clazz;
}