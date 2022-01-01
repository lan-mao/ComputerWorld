package top.lanmao.computerworld.study202112.spring.mybatis.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.lanmao.computerworld.study202112.spring.mybatis.dao.UserInfoDAO;
import top.lanmao.computerworld.study202112.spring.mybatis.pojo.UserInfoDO;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create Date 2021/12/14 23:32:27 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Service
public class UserService {

    @Resource
    public UserInfoDAO userInfoDAO;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.SUPPORTS)
    public List<UserInfoDO> listAllUser() {
        return userInfoDAO.listAllUser();
    }
}