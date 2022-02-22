package top.lan_mao.computer_world.study_2022.springmvc_demo05_ajax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lan_mao.computer_world.study_2022.springmvc_demo05_ajax.pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create Date 2022/01/11 20:5:57 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@RestController
public class AjaxController {

    @RequestMapping("/h1")
    public String hello() {
        return "你好";
    }

    @RequestMapping("/a1")
    public void ajax01(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1>" + name);
        if ("mx".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> ajax02() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1号", 11, "男"));
        userList.add(new User("2号", 12, "女"));
        userList.add(new User("3号", 13, "男"));
        return userList;
    }

    @RequestMapping("/a3")
    public String ajax03(String username, String password) {
        String msg = "";
        if (username != null) {
            if ("admin".equals(username)) {
                msg = "OK";
            } else {
                msg = "用户名无效";
            }
        }
        if (password != null) {
            if ("123456".equals(password)) {
                msg = "ok";
            } else {
                msg = "密码错误";
            }
        }
        System.out.println("username:" + username + "\npassword:" + password);
        System.out.println(msg);
        return msg;
    }
}