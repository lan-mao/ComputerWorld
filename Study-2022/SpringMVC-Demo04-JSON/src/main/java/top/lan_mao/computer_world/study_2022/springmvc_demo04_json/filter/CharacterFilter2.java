package top.lan_mao.computer_world.study_2022.springmvc_demo04_json.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/")
public class CharacterFilter2 implements Filter {
    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("CharacterFilter2");
        //request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
        //response.setContentType("text/html;charset=UTF-8");
    }
}