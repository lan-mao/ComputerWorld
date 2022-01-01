package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create Date 2020/09/23 15:40:49
 * Created by lan-mao.top
 */

public class FirstInterceptor implements HandlerInterceptor {
    //请求处理器方法执行之前执行
    //如果返回false，则不执行处理器方法，true则执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = Math.random() * 10 > 5;
        System.out.println("拦截器执行----"+ result);
        return result;
    }

    //在请求处理方法执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在所有过程执行之后，在返回浏览器之前执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}