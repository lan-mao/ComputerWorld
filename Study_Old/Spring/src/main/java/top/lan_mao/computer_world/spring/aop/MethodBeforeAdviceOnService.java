package top.lan_mao.computer_world.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Create Date 2020/09/09 9:40
 * Created by lan-mao.top
 *  - 前置通知
 */

//创建一个前置通知的代理类，需要实现org.springframework.aop.MethodBeforeAdvice接口
public class MethodBeforeAdviceOnService implements MethodBeforeAdvice {

    /**
     * @param method 目标方法
     * @param objects 目标方法的参数列表
     * @param o 目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("前置通知方法执行");
    }
}