import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import util.MybatisUtil;

/**
 * Create Date 2020/02/29 14:50
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class TestInsert {
    @Test
    public void testInsert(){
        SqlSession session = MybatisUtil.getSession();
        User user = new User();
        user.setUsername("test");
        user.setPassword("qq");

        int num = session.insert("mapper.UserMapper.insertUser" , user);
        if (num > 0) {
            session.commit();
        } else {
            session.rollback();
        }
    }
}
