package top.lanmao.computer_world.spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Create Date 2020/09/09 10:16
 * Created by lan-mao.top
 *  - 后置通知切面
 */

public class ServiceMethodAfterReturningAdvice implements AfterReturningAdvice {
    /**
     * @param returnValue 方法返回值
     * @param method 执行的方法
     * @param args 方法参数
     * @param target 目标对象
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置通知执行。返回：" + returnValue);
    }
}