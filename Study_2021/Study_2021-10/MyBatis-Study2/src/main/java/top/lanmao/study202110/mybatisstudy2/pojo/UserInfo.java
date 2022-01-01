package top.lanmao.study202110.mybatisstudy2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * Create Date 2021/11/04 9:23:26 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserInfo {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userRealName;
    private String userImg;
    private Timestamp createTime;
    private Timestamp updateTime;

    private UserDetail userDetail;
}