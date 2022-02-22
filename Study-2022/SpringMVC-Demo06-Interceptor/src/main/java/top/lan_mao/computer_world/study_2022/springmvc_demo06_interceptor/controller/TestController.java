package top.lan_mao.computer_world.study_2022.springmvc_demo06_interceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lan_mao.computer_world.study_2022.springmvc_demo06_interceptor.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create Date 2022/01/13 12:4:47 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@RestController
public class TestController {

    @RequestMapping("/t1")
    public Object getUser01() {
        User user = new User("姓名", 12);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/t2")
    public String getParam(String name, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        System.out.println(name);
        System.out.println(req.getAttribute("name"));
        System.out.println(req.getParameter("name"));
        System.out.println(resp.getCharacterEncoding());
        System.out.println(resp.getContentType());
        System.out.println(req.getCharacterEncoding());
        System.out.println(req.getContentType());
        System.out.println("-------");

        //resp.setContentType("text/plain;charset=UTF-8");

        return "姓名";

        //resp.getWriter().println("姓名");
    }
}