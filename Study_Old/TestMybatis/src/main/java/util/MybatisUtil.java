package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Create Date 2020/02/29 14:46
 * Created by lan-mao.top
 */
 
public class MybatisUtil {
    private static SqlSessionFactory factory = null;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        SqlSession session = null;
        if (factory!=null) {
            session = factory.openSession();
        }
        return session;
    }
}
