package top.lanmao.computerworld.study202112.spring.aop.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Create Date 2021/12/10 21:47:37 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class CGLibDynamicProxy {

    private final Object object;

    public CGLibDynamicProxy(Object object) {
        this.object = object;
    }

    public Object getProxyObject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * @param obj "this", the enhanced object
             * @param method 调用的方法
             * @param args 调用方法时传入的参数
             * @param proxy 方法的代理对象，用于执行
             */
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                begin();
                Object result = method.invoke(object, args);
                // 与上面的语句一样
                Object result2 = proxy.invokeSuper(obj, args);
                end();
                return result2;
            }
        });
        return enhancer.create();
    }
    private void begin() {
        System.out.println("----开始----");
    }
    private void end() {
        System.out.println("----结束----");
    }
}