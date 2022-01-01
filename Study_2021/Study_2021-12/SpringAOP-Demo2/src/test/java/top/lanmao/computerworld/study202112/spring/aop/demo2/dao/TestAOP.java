package top.lanmao.computerworld.study202112.spring.aop.demo2.dao;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lanmao.computerworld.study202112.spring.aop.demo2.aop.MyAspect;

class TestAOP {

    @Test
    void testSpringAOPAnnotation() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDAO bookDAO = context.getBean("bookDAO", BookDAO.class);
        bookDAO.delete();
        MyAspect myAspect = context.getBean(MyAspect.class);
        myAspect.after();
    }

}