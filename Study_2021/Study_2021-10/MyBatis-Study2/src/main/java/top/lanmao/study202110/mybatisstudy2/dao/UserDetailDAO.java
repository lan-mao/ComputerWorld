package top.lanmao.study202110.mybatisstudy2.dao;

import top.lanmao.study202110.mybatisstudy2.pojo.UserDetail;

/**
 * Create Date 2021/11/04 11:15:47 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface UserDetailDAO {

    int insertUserDetail(UserDetail user);

    UserDetail getUserDetailByUserId(Long userId);
}