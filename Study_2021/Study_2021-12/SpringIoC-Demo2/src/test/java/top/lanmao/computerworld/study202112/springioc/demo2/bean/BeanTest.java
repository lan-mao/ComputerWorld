package top.lanmao.computerworld.study202112.springioc.demo2.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

    @Test
    void testLazy() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("----1-----");
        Student student1 = context.getBean("student", Student.class);
        System.out.println(student1);
        System.out.println("----2-----");

        Student student2 = context.getBean("student", Student.class);
        System.out.println(student2);
    }
}