package controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create Date 2020/08/29 19:28
 * Created by lan-mao.top
 *  - 入门SpringMVC
 */

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView dataModel = new ModelAndView();
        dataModel.addObject("msg", "Hello World!");
        dataModel.setViewName("/jsp/HelloWorld.jsp");
        return dataModel;
    }
}