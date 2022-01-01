package top.lanmao.computerworld.study202112.spring.mybatis.dao;

import top.lanmao.computerworld.study202112.spring.mybatis.pojo.UserInfoDO;

import java.util.List;

/**
 * Create Date 2021/12/14 14:53:12 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public interface UserInfoDAO {

    List<UserInfoDO> listAllUser();

}