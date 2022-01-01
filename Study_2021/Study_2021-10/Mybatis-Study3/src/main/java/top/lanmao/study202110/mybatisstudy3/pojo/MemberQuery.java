package top.lanmao.study202110.mybatisstudy3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;

/**
 * Create Date 2021/11/09 10:58:35 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MemberQuery {
    private Long memberId;
    private String memberNick;
    private Integer memberGender;
    private Integer memberAge;
    private Integer maxAge;
    private Integer minAge;
    private List<String> memberCity;
    private Timestamp createTime;
    private Timestamp updateTime;
}