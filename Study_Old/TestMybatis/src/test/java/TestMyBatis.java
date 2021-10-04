import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pojo.User;
import util.MybatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Create Date 2020/02/26 21:11
 * Created by lan-mao.top
 *
 */

public class TestMyBatis {

    @Test
    public void testGetAll() throws IOException {
        //加载MyBatis配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //构建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //通过工厂打开SqlSession
        SqlSession session = factory.openSession();
        //通过Session执行查询操作
        List<User> li = session.selectList("mapper.UserMapper.getAll");
        System.out.println(li);
        //关闭资源
        session.close();
        resourceAsStream.close();
    }
    @Test
    public void testName() throws IOException {
        //加载MyBatis配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //构建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //通过工厂打开SqlSession
        SqlSession session = factory.openSession();
        //通过Session执行查询操作
        User user = session.selectOne("mapper.UserMapper2.find");
        System.out.println(user);
        //关闭资源
        session.close();
        resourceAsStream.close();
    }

    @Test
    public void testByInterface(){
        SqlSession session = MybatisUtil.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findById(1);
        System.out.println(user);
        session.close();
    }

}