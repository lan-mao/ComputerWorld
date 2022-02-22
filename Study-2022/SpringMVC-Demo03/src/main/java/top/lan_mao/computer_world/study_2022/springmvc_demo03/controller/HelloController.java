package top.lan_mao.computer_world.study_2022.springmvc_demo03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Create Date 2022/01/07 17:5:57 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/h1",method = {RequestMethod.GET,RequestMethod.POST})
    public String hello1(Model model) {
        model.addAttribute("msg", "Hello");
        return "hello";
    }

    @RequestMapping(value = "/h2/{a}/{b}",method = RequestMethod.GET)
    public String hello2(@PathVariable Integer a, @PathVariable Integer b, Model model) {
        model.addAttribute("msg", a + b);
        return "hello";
    }
    @RequestMapping("/h2")
    public String hello3(Integer a, Integer b, Model model) {
        model.addAttribute("msg", a + b);
        System.out.println("aaa");
        return "hello";
    }

    @RequestMapping("/h3")
    public String hello3(Model model) {
        model.addAttribute("msg", "a + b");
        return "forward:/hello";
    }
    @RequestMapping("/h4")
    public String hello4(Model model) {
        model.addAttribute("msg", "a + b");
        return "redirect:/hello";
    }
    @RequestMapping("/h5")
    public String hello5(Model model) {
        model.addAttribute("msg", "a + b");
        return "forward:hello";
    }

    @RequestMapping("/h6")
    public String hello6(Model model) {
        model.addAttribute("msg", "a + b");
        return "redirect:h2?a=1&b=2";
    }
    @RequestMapping("/h7")
    public String hello7(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("msg", "a + b");
        return "redirect:/WEB-INF/jsp/hello.jsp";
    }
}