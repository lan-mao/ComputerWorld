package top.lan_mao.tacocloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lan_mao.tacocloud.bean.Order;

import javax.validation.Valid;

/**
 * Create Date 2021/04/13 19:29:50 <br>
 * 展现Taco订单表单控制器
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.debug("Order submitted: " + order);
        return "redirect:/";
    }
}