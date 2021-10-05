package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.FormPOJO;

import java.util.List;

/**
 * Create Date 2020/09/20 10:57:38
 * Created by lan-mao.top
 */

@Controller
@RequestMapping("/request")
public class GetRequestParametersController {

    //@RequestMapping("/get")
    public ModelAndView get01(String password, String username) {
        ModelAndView model = new ModelAndView();
        model.addObject("username", username);
        model.addObject("password", password);
        model.setViewName("welcome");
        return model;
    }
    //@RequestMapping("/get")
    public ModelAndView get02(@RequestParam("password") String passwd, String username) {
        ModelAndView model = new ModelAndView();
        model.addObject("username", username);
        model.addObject("password", passwd);
        model.setViewName("welcome");
        return model;
    }
    //@RequestMapping("/get")
    public ModelAndView get03(FormPOJO formPOJO) {
        ModelAndView model = new ModelAndView();
        model.addObject("username", formPOJO.getUsername());
        model.addObject("password", formPOJO.getPassword());
        model.setViewName("welcome");
        return model;
    }
    //@RequestMapping("/get")
    public String get04(String[] checkbox) {
        for (String s : checkbox) {
            System.out.println(s);
        }
        return "welcome";
    }
    //@RequestMapping("/get")
    public String get05(@RequestParam List<String> checkbox) {
        for (String s : checkbox) {
            System.out.println(s);
        }
        return "welcome";
    }
    //@RequestMapping("/get")
    public ModelAndView get06(FormPOJO formPOJO) {
        ModelAndView model = new ModelAndView();
        model.addObject("username", formPOJO.getUsername());
        model.addObject("password", formPOJO.getPassword());
        //model.addObject("partner", formPOJO.getPartner().getUsername());
        model.setViewName("welcome");
        return model;
    }

    //restful风格传参
    //即用 /request/name/password/get 的URL格式传递参数
    //@RequestMapping("/{name}/{password}/get")
    public ModelAndView get07(@PathVariable String name, @PathVariable String password) {
        ModelAndView model = new ModelAndView();
        model.addObject("username", name);
        model.addObject("password", password);
        model.setViewName("welcome");
        return model;
    }

    //接收JSON字符串
    @RequestMapping("/get")
    public ModelAndView get08(@RequestBody FormPOJO formPOJO) {
        System.out.println(formPOJO);
        ModelAndView model = new ModelAndView();
        model.addObject("username", formPOJO.getUsername());
        model.addObject("password", formPOJO.getPassword());
        model.setViewName("welcome");
        return model;

    }

    @RequestMapping("/header")
    public void get09(@RequestHeader String cookie, @RequestHeader("user-agent") String header) {
        System.out.println(cookie);
        System.out.println(header);
    }



}