package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.FormPOJO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Create Date 2020/09/21 15:34:04
 * Created by lan-mao.top
 */

@Controller
@RequestMapping("/response")
public class ResponseHeader {

    @RequestMapping("/string")
    public String returnString(Model model, Map<String,Object> map, ModelMap modelMap) {
        model.addAttribute("model", "model111");
        map.put("map", "map1111111");
        modelMap.addAttribute("modelMap", "model_map11111");
        return "response";
    }
    @RequestMapping(value = "/string-content",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String returnString2() {
        return "response：中文";
    }

    @RequestMapping("/void")
    public void returnVoid(HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("你好");
    }

    @RequestMapping("/object")
    @ResponseBody
    public FormPOJO returnObject() {
        FormPOJO formPOJO = new FormPOJO();
        formPOJO.setUsername("user");
        formPOJO.setPassword("test");
        return formPOJO;
    }

    @RequestMapping("/redirect")
    public ModelAndView returnRedirect(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "user");
        modelAndView.addObject("password", "test");
        FormPOJO formPOJO = new FormPOJO("mx","passwd");
        session.setAttribute("object", formPOJO);
        modelAndView.setViewName("redirect:/jsp/welcome.jsp");
        return modelAndView;
    }
}