package top.lanmao.study202110.mybatisstudy2.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Create Date 2021/11/03 17:47:32 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * mybatis的工具类 <br>
 */
public class MyBatisUtils {

    private static SqlSession sqlSession;
    private static SqlSessionFactory factory;

    static{
        try {
            factory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsReader("mybatis-config.xml"));
            sqlSession = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个不会自动提交的session
     */
    public static SqlSession getSqlSessionNotAutoCommit() {
        return factory.openSession();
    }

    /**
     * 获取mapper，会自动提交
     */
    public static <T> T getMapper(Class<T> clazz) {
        return sqlSession.getMapper(clazz);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }

}