package top.lanmao.tacocloud.web;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Create Date 2021/04/18 21:34:16 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}