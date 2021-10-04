import org.apache.ibatis.session.SqlSession;
import pojo.User;
import util.MybatisUtil;

/**
 * Create Date 2020/02/29 14:58
 * Created by lan-mao.top
 * TODO 
 *  - 
 */
 
public class TestDML {
    public void testUpdate(){
        User user = new User();
        user.setUsername("daming");
        user.setPassword("da");
        user.setId(3);
        SqlSession session = MybatisUtil.getSession();

    }
}
