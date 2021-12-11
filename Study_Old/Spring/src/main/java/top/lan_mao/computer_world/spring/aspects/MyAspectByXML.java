package top.lanmao.computer_world.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Create Date 2020/09/10 10:13
 * Created by lan-mao.top
 */

@Aspect //表明当前类是一个切面
public class MyAspectByXML {

    //此表达式代表：所有返回值类型的 在所有的包的 service包下面的 所有类 的 不限制参数类型的 doSomething方法
    //@Before("execution(* *..service.*.doSomething(..))")
    public void before(){
        System.out.println("Aspectj前置通知执行2");
    }

    public void before(JoinPoint joinPoint){
        System.out.println("Aspectj前置通知执行2 jp=" + joinPoint);
    }

    //@AfterReturning(value = "execution(* *..service.*.doNothing(..))", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("AspectJ返回通知执行 ->" + result);
    }

    //@Around("execution(* *..service.*.doNothing(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕方法前置执行2");
        String proceed = (String) pjp.proceed();
        System.out.println(proceed!= null ? proceed.toUpperCase() : null) ;
        System.out.println("环绕方法后置执行2");
        return proceed;
    }

    //@AfterThrowing(value = "execution(* *..service.*.doNothing(..))", throwing = "e")
    public void afterThrowing(Exception e) {
        System.out.println("AspectJ异常通知执行2");
        e.printStackTrace();
    }
    //@After("execution(* *..service.*.doSomething(..))")
    public void after(){
        System.out.println("Aspectj前置通知执行2");
    }
}