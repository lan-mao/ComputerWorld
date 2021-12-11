package top.lanmao.study202110.mybatisstudy2.dao;

import top.lanmao.study202110.mybatisstudy2.pojo.UserInfo;

/**
 * Create Date 2021/11/04 11:16:2 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface UserInfoDAO {

    int insertUserInfo(UserInfo userInfo);

    UserInfo getUserInfoByUsername(String username);


}