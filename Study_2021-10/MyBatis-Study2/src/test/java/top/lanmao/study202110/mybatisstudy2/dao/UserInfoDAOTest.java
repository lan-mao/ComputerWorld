package top.lanmao.study202110.mybatisstudy2.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import top.lanmao.study202110.mybatisstudy2.pojo.UserDetail;
import top.lanmao.study202110.mybatisstudy2.pojo.UserInfo;
import top.lanmao.study202110.mybatisstudy2.util.MyBatisUtils;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInfoDAOTest {


    @org.junit.jupiter.api.Test
    void insertUserInfo() {
        UserInfoDAO userInfoDAO = MyBatisUtils.getMapper(UserInfoDAO.class);
        UserInfo userInfo = new UserInfo()
                .setUserName("li")
                .setUserPassword("test")
                .setUserRealName("li")
                .setUserImg("01.jpg")
                .setCreateTime(new Timestamp(System.currentTimeMillis()))
                .setUpdateTime(new Timestamp(System.currentTimeMillis()));

        assertEquals(userInfoDAO.insertUserInfo(userInfo), 1);
        System.out.println(userInfo);
    }

    @Test
    void insertUser(){
        UserInfo userInfo = new UserInfo()
                .setUserName("liu2")
                .setUserPassword("test")
                .setUserRealName("li")
                .setUserImg("01.jpg")
                .setCreateTime(new Timestamp(System.currentTimeMillis()))
                .setUpdateTime(new Timestamp(System.currentTimeMillis()));
        UserDetail userDetail = new UserDetail()
                .setUserAddress("山东省")
                .setUserTel("12345678901")
                .setUserDescription("有个性才签名")
                .setCreateTime(new Timestamp(System.currentTimeMillis()))
                .setUpdateTime(new Timestamp(System.currentTimeMillis()));
        SqlSession sqlSession = MyBatisUtils.getSqlSessionNotAutoCommit();
        UserInfoDAO userInfoDAO = sqlSession.getMapper(UserInfoDAO.class);
        UserDetailDAO userDetailDAO = sqlSession.getMapper(UserDetailDAO.class);
        try {
            assertEquals(userInfoDAO.insertUserInfo(userInfo), 1);
            userDetail.setUserId(userInfo.getUserId());
            assertEquals(userDetailDAO.insertUserDetail(userDetail), 1);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally{
            sqlSession.close();
        }
    }

    @Test
    void testGetUserInfo() {
        UserInfoDAO userInfoDAO = MyBatisUtils.getMapper(UserInfoDAO.class);
        UserInfo userInfo = userInfoDAO.getUserInfoByUsername("liu");
        System.out.println(userInfo);
    }

}