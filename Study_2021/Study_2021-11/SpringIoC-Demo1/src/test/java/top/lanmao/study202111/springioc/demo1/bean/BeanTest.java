package top.lanmao.study202111.springioc.demo1.bean;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanTest {

    @Test
    void testBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student01 = context.getBean("student01", Student.class);
        System.out.println(student01);
    }

    @Test
    void testBeanLifecycle() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book1 = context.getBean("book", Book.class);
        System.out.println("----------");
        Book book2 = context.getBean("book", Book.class);
        System.out.println("book2 == book1 :" + (book2 == book1));
        System.out.println("----------");
        Book book3 = beSonOfTestBeanLifecycle();
        System.out.println("book3 == book1 :" + (book3 == book1));
        System.out.println("book3 == book2 :" + (book3 == book2));
        System.out.println("----------");
    }

    Book beSonOfTestBeanLifecycle() {
        System.out.println("~~~~~~~~~~");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println("~~~~~~~~~~");
        return context.getBean("book", Book.class);
    }

    @SneakyThrows
    @Test
    void testReflex() {
        // 获取类的全限定名
        String classPath = "top.lanmao.study202111.springioc.demo1.bean.Student";
        // 从限定名获取类
        Class<?> clazz = Class.forName(classPath);
        //通过反射创建类的对象
        Object obj = clazz.getDeclaredConstructor().newInstance();
        // 通过反射获取定义的所有方法
        //Method[] methods = clazz.getDeclaredMethods();
        // 通过反射获取定义的所有属性（包括私有属性）
        //Field[] fields = clazz.getDeclaredFields();
        try {
            // 获取属性名对应的属性
            Field field = clazz.getDeclaredField("stuName");
            // 得到setter、getter方法的名称
            String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            // 通过方法名称和参数类型列表，获取对应的方法
            Method method = clazz.getDeclaredMethod(methodName, field.getType());
            // 在类的对象中执行该方法，并传入参数
            method.invoke(obj, "张三");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        System.out.println(obj);
    }
}