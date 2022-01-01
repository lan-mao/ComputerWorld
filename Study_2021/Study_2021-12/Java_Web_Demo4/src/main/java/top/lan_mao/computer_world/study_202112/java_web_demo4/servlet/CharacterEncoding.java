package top.lan_mao.computer_world.study_202112.java_web_demo4.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Create Date 2021/12/31 22:12:50 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class CharacterEncoding implements Filter {
    // 初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}