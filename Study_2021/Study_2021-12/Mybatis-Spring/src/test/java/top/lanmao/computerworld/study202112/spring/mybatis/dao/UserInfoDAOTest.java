package top.lanmao.computerworld.study202112.spring.mybatis.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class UserInfoDAOTest {

    @org.junit.jupiter.api.Test
    void listAllUser() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoDAO userInfoDao = context.getBean("userInfoDAO", UserInfoDAO.class);
        System.out.println(userInfoDao);
    }
}