package top.lan_mao.computer_world.study_2022.springmvc_demo01.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create Date 2022/01/04 21:15:18 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg", "Hello");


        mv.setViewName("hello");
        return mv;
    }
}