import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
             * @param proxy
             */
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                begin();
                Object result = method.invoke(object, args);
                end();
                return result;
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