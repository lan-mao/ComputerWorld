package top.lanmao.study202110.mybatisstudy3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Create Date 2021/11/09 10:40:41 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long memberId;
    private String memberNick;
    private Integer memberGender;
    private Integer memberAge;
    private String memberCity;
    private Timestamp createTime;
    private Timestamp updateTime;
}