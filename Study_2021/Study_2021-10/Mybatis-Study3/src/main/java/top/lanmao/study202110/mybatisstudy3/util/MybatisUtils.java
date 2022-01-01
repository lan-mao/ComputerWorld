package top.lanmao.study202110.mybatisstudy3.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Create Date 2021/11/22 20:11:11 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class MybatisUtils {
    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> LOCAL = new ThreadLocal<>();

    static {
        try {
            factory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsReader("mybatis-config.xml"));
            SqlSession session = factory.openSession(true);
            LOCAL.set(session);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T getMapper (Class<T> type) {
        return getSession().getMapper(type);
    }

    public static SqlSession getSession() {
        SqlSession session = LOCAL.get();
        if (session == null) {
            session = factory.openSession(true);
            LOCAL.set(session);
        }
        return session;
    }

    public static SqlSession getSqlSessionNotAutoCommit() {
        return factory.openSession(false);
    }

    public static void close() {
        getSession().close();
        LOCAL.remove();
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }

}