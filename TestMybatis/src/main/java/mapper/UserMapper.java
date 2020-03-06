package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

/**
 * Create Date 2020/02/29 16:52
 * Created by lan-mao.top
 * TODO 
 *  - UserMapper的接口
 */
 
public interface UserMapper {
    User getAll();
    User findById(Integer id);
    void insertUser(User user);
    void updateUser(User user);

    User findByUser(@Param("username") String username ,@Param("password") String password);
    User listUserByUsernameAndPassword(@Param("username") String username ,@Param("password") String password);
    User listUserByUsernameOrPassword(@Param("username") String username ,@Param("password") String password);

    int updateUserById(@Param("id") Integer id,@Param("username")  String username, @Param("password") String password);
}
