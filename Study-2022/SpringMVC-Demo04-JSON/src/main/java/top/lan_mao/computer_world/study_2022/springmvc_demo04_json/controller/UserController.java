package top.lan_mao.computer_world.study_2022.springmvc_demo04_json.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lan_mao.computer_world.study_2022.springmvc_demo04_json.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Create Date 2022/01/09 18:38:43 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@Controller
@ResponseBody
//@RestController
public class UserController {

    @RequestMapping("/u1")
    //@ResponseBody
    public String getUser1() {
        User user = new User("电脑", 12, "男");
        return user.toString();
    }
    @RequestMapping("/u2")
    //@ResponseBody
    public String getUser2() throws JsonProcessingException {
        User user = new User("电脑", 12, "男");
        return new ObjectMapper().writeValueAsString(user);
    }

    /**
     * 解决乱码问题，添加了RequestMapping的produces属性，但请求的Accept字段中必须包含对应的协议类型
     */
    @RequestMapping(value="/u3", produces = "application/json;charset=UTF-8")
    //@ResponseBody
    public String getUser3() throws JsonProcessingException {
        User user = new User("电脑", 12, "男");
        return new ObjectMapper().writeValueAsString(user);
    }

    @RequestMapping("/u4")
    //@ResponseBody
    public User getUser4(HttpServletRequest request, HttpServletResponse response) {
        return new User("电脑", 12, "男");
    }

    @RequestMapping("/u5")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User("电脑1", 12, "男");
        User user2 = new User("电脑2", 12, "男");
        User user3 = new User("电脑3", 12, "男");
        User user4 = new User("电脑4", 12, "男");
        User user5 = new User("电脑5", 12, "男");
        User user6 = new User("电脑6", 12, "男");
        User user7 = new User("电脑7", 12, "男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        return users;
    }
}