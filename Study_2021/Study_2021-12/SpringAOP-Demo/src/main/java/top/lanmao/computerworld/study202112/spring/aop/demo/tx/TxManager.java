package top.lanmao.computerworld.study202112.spring.aop.demo.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Create Date 2021/12/11 18:7:12 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class TxManager {

    /**
     * 前置通知
     * @param joinPoint JoinPoint，存储目标方法的信息
     */
    public void begin(JoinPoint joinPoint) {
        System.out.println("执行方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("----开启事务----");
    }

    /**
     * 后置通知，方法执行成功后执行
     * @param returnValue 成功执行后的返回值，最好是Object类型
     */
    public void commit(Object returnValue) {
        System.out.println("返回：" + returnValue);
        System.out.println("----提交事务----");
    }

    /**
     * 异常通知
     * @param e 参数名是在配置文件中指定的，最好是Throwable类型
     */
    public void rollback(Exception e) {
        e.printStackTrace();
        System.out.println("----回滚事务----");
    }

    /**
     * 最终通知，无论方法是否成功执行
     */
    public void after() {
        System.out.println("----记录日志----");
    }

    /**
     * 环绕通知
     * 返回值、参数、抛出异常都不是必须的，可以省略。但最好按照这样的格式，否则可能会有未知错误
     * @param proceedingJoinPoint 是JoinPoint子接口，专用于around通知，可以执行目标方法
     * @return 返回值，最好是Object
     * @throws Throwable 抛出异常，是Throwable
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("----环绕开始----");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("----环绕结束----");
        return result;
    }
}