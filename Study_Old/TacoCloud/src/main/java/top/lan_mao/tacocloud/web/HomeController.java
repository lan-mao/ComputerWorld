package top.lan_mao.tacocloud.web;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Create Date 2021/04/04 9:36:16 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * 主页 <br>
 */
//控制器
//@Controller
public class HomeController {
    //处理对路径”/“的请求
    @GetMapping("/")
    public String homePage() {
        //返回视图名
        return "home";
    }
}