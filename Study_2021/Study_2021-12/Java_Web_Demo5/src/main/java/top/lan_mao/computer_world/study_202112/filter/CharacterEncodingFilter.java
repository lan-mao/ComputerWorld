package top.lan_mao.computer_world.study_202112.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * Create Date 2021/12/31 22:48:36 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@WebFilter("/servlet/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        response.getWriter().println("过滤器执行开始");
        chain.doFilter(request, response);
        response.getWriter().println("过滤器执行结束");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}