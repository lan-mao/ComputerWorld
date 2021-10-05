import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lan_mao.computer_world.spring.proxy.ServiceProxyByCglibProxyFactory;
import top.lan_mao.computer_world.spring.proxy.ServiceProxyByStatic;
import top.lan_mao.computer_world.spring.service.DoSomethingService;
import top.lan_mao.computer_world.spring.service.impl.DoSomethingServiceImpl;
import top.lan_mao.computer_world.spring.service.impl.NoImplementsClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * Create Date 2020/09/07 9:51
 * Created by lan-mao.top
 *  - 测试Spring
 */

public class SomeTest {

    @Test
    public void someTest01() {
        DoSomethingService service = new DoSomethingServiceImpl();
        service.doSomething();
    }


    @Test
    public void someTest02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DoSomethingService doSomethingService = applicationContext.getBean("doSomethingService", DoSomethingService.class);
        doSomethingService.doSomething();
    }
    @Test
    public void someTest03() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DoSomethingService doSomethingService = applicationContext.getBean("doSomethingService", DoSomethingService.class);
        doSomethingService.doSomething();
    }
    @Test
    public void someTest04() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DoSomethingService doSomethingService = applicationContext.getBean("doSomethingService", DoSomethingService.class);
        System.out.println(doSomethingService);
    }

    @Test
    public void someTest05(){
        //定义目标对象
        DoSomethingService target = new DoSomethingServiceImpl();
        //定义目标对象的代理对象
        DoSomethingService proxy = new ServiceProxyByStatic(target);
        String result = proxy.doSomething();
        System.out.println(result);
    }

    /**
     * 使用JDK代理DoSomethingServiceImpl类，对其进行增强
     */
    @Test
    public void someTest06() {
        //定义目标对象
        //由于需要在内部类中调用该变量，需要使用 final 修饰
        final DoSomethingService target = new DoSomethingServiceImpl();
        //定义目标对象的代理类
        DoSomethingService proxy = (DoSomethingService) Proxy.newProxyInstance(target.getClass().getClassLoader(), //目标类的类加载器
                target.getClass().getInterfaces(), //目标类实现的接口
                new InvocationHandler() {  //新建调用处理器
                    @Override
                    /*
                     * proxy : 代理对象
                     * method ： 目标方法
                     * args ： 目标方法的参数
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String result = (String) method.invoke(target, args);
                        return result.toUpperCase();
                    }
                });
        String result = proxy.doSomething();
        System.out.println(result);
    }

    /**
     * 使用cglib进行代理
     */
    @Test
    public void someTest07() {
        //定义目标对象
        NoImplementsClass target = new NoImplementsClass();
        //定义目标对象的代理对象
        NoImplementsClass proxy = new ServiceProxyByCglibProxyFactory(target).proxyCreator();
        System.out.println(proxy.doSomething());
        System.out.println(proxy.returnNotString());
    }

    @Test
    public void someTest08() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取代理bean
        DoSomethingService somethingService = context.getBean("proxyFactoryBean", DoSomethingService.class);
        somethingService.doSomething();
        String s = somethingService.doNothing();
        System.out.println(s);
    }
    @Test
    public void someTest09() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DoSomethingService service = context.getBean("afterProxyFactoryBean", DoSomethingService.class);
        System.out.println(service.doSomething());
        System.out.println(service.doNothing());
    }

    @Test
    public void someTest10() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DoSomethingService service = context.getBean("interceptorProxyFactoryBean", DoSomethingService.class);
        System.out.println(service.doNothing());
        System.out.println(service.doSomething());
    }

    @Test
    public void someTest11() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DoSomethingService service = applicationContext.getBean("throwsProxyFactoryBean", DoSomethingService.class);
        System.out.println(service.doNothing());
        System.out.println(service.doSomething());
    }

    @Test
    public void someTest12() {
        String a = "";
        a = Math.random() * 10 >5 ?null:"aaa";
        System.out.println(Objects.requireNonNull(a).length());
    }
}