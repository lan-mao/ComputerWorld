import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create Date 2021/12/08 17:52:36 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class JDKDynamicProxy {
    private final Object obj;

    public JDKDynamicProxy(Object obj) {
        this.obj = obj;
    }

    /**通过JDK，实现动态代理*/
    public Object getProxyObject() {
        // 获取类加载器
        ClassLoader classLoader = obj.getClass().getClassLoader();
        // 获取obj对象所有实现的接口
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            /**
             * @param proxy 调用该方法的对象，实际是一个Proxy类的内部类，以JDKDynamicProxy的对象作为一个唯一属性，
             *              其传入的值是语句返回值：Reflection.getCallerClass()
             * @param method 调用的方法
             * @param args 调用的方法传入的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                begin();
                Object result = method.invoke(obj, args);
                end();
                return result;
            }
        });
    }

    private void begin() {
        System.out.println("----开始----");
    }
    private void end() {
        System.out.println("----结束----");
    }
}