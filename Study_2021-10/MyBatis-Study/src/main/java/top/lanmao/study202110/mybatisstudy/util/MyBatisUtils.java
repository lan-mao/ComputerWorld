package top.lanmao.study202110.mybatisstudy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Create Date 2021/10/29 10:35:5 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * MyBatis的工具类 <br>
 */
public class MyBatisUtils {

    private static SqlSessionFactory factory;
    private static SqlSession session;

    static{
        try {
            factory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsReader("mybatis-config.xml")
            );
            session = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个不会自动提交的session对象
     */
    public static SqlSession getSqlSessionNotAutoCommit() {
        return factory.openSession(false);
    }


    /**
     * 直接获取DAO对象，会自动提交
     * 用于select等不需要修改数据库的操作
     */
    public static <T> T getMapper(Class<T> type) {
        return session.getMapper(type);
    }

}