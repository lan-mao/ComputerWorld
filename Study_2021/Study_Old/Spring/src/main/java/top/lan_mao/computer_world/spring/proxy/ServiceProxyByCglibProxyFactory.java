package top.lanmao.computer_world.spring.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import top.lanmao.computer_world.spring.service.impl.NoImplementsClass;

import java.lang.reflect.Method;

/**
 * Create Date 2020/09/08 17:30
 * Created by lan-mao.top
 *  - 通过Cglib的动态代理工厂类代理
 */

//cglib动态工厂
public class ServiceProxyByCglibProxyFactory implements MethodInterceptor {

    private NoImplementsClass target;

    public ServiceProxyByCglibProxyFactory() {
    }

    public ServiceProxyByCglibProxyFactory(NoImplementsClass target) {
        this.target = target;
    }

    //第一步，创建动态代理对象
    public NoImplementsClass proxyCreator() {
        //创建增强器
        Enhancer enhancer = new Enhancer();
        //指定父类（指定目标类）
        enhancer.setSuperclass(NoImplementsClass.class);
        //指定回调接口对象
        enhancer.setCallback(this);
        //创建cglib代理对象
        return (NoImplementsClass) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String result = (String) method.invoke(target, objects);
        return result.toLowerCase();
    }
}