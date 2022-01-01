package top.lanmao.computerworld.study202112.spring.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Create Date 2021/12/14 14:43:30 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDO {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userRealName;
    private String userImg;
    private Timestamp createTime;
    private Timestamp updateTime;
}