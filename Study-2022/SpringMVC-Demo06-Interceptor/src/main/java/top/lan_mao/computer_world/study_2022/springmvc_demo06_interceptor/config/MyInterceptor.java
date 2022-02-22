package top.lan_mao.computer_world.study_2022.springmvc_demo06_interceptor.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create Date 2022/01/13 12:0:22 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
@AllArgsConstructor
@NoArgsConstructor
public class MyInterceptor implements HandlerInterceptor {
    private String encoding = "utf-8";

    /**
     * @return true，执行下一个拦截器，放行；false，不执行下一个拦截器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String requestEncoding = request.getCharacterEncoding();
        //String responseEncoding = response.getCharacterEncoding();
        //request.setCharacterEncoding(encoding);
        //if (requestEncoding == null) {
        //
        //} else {
        //    if (!encoding.equals(requestEncoding.toLowerCase())) {
        //        System.out.println("此次请求中的编码格式为：" + requestEncoding);
        //        System.out.println(request.getContentType());
        //    }
        //}
        //if (responseEncoding == null) {
        //    response.setCharacterEncoding(encoding);
        //    response.setContentType("text/plain;charset=UTF-8");
        //} else {
        //    if (!encoding.equals(responseEncoding.toLowerCase())) {
        //        System.out.println("此次请求中的编码格式为：" + responseEncoding);
        //        System.out.println(response.getContentType());
        //    }
        //}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}