package top.lanmao.study202110.mybatisstudy2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * Create Date 2021/11/04 9:38:54 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDetail {
    private Long detailId;
    private String userAddress;
    private String userTel;
    private String userDescription;
    private Long userId;
    private Timestamp createTime;
    private Timestamp updateTime;
}