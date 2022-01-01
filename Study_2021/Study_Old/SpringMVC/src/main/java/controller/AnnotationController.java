package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create Date 2020/09/05 11:25
 * Created by lan-mao.top
 *  - SpringMVC注解式开发
 */

@Controller //表示将当前类交由Spring容器管理
@RequestMapping(value="/annotation")  //表示url中对应这个类的请求路径，有些命名空间的意思
public class AnnotationController {

    @RequestMapping("/hello-world")
    public ModelAndView helloWorldController (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "Hello SpringMVC");
        modelAndView.setViewName("/jsp/HelloWorld.jsp");
        return modelAndView;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "welcome";
    }
}