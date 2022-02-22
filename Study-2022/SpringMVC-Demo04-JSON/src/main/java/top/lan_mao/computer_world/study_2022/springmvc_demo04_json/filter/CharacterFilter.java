package top.lan_mao.computer_world.study_2022.springmvc_demo04_json.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("01");
        request.setCharacterEncoding("UTF-8");
        System.out.println(response.getCharacterEncoding());
        response.setContentType("text/html;charset=ISO-8859-1");
        chain.doFilter(request, response);
        System.out.println(response.getContentType());
        if (!"UTF-8".equals(response.getCharacterEncoding())) {
            response.setContentType("text/html;charset=UTF-8");
            System.out.println("03");
        }
        System.out.println("02");
    }
}