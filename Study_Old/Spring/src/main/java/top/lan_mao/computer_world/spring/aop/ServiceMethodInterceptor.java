package top.lan_mao.computer_world.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Create Date 2020/09/09 10:31
 * Created by lan-mao.top
 *  - 环绕通知
 */

public class ServiceMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //与前置通知和后置通知不同的是，这个方法具有返回值
        //在调用该方法时，Spring不会自动执行目标函数的方法，而是需要自己调用
        System.out.println("方法执行前");
        Object proceed = invocation.proceed();
        System.out.println("方法执行后");
        return proceed == null ? "" : ((String)proceed).toUpperCase() ;
    }
}