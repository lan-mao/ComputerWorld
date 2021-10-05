package top.lan_mao.computer_world.spring.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * Create Date 2020/09/09 16:33
 * Created by lan-mao.top
 *  - 异常通知
 */

public class ServiceMethodThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("异常通知方法执行");
        ex.printStackTrace();
    }
}