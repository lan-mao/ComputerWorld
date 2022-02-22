package top.lan_mao.computer_world.study_2022.springmvc_demo02;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 12641
 */
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "HELLO");
        modelAndView.setViewName("hello"); //WEB-INF/jsp/hello.jsp
        return modelAndView;
    }

}