import org.junit.jupiter.api.Test;

/**
 * Create Date 2021/12/08 18:8:7 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class DynamicTest {
    @Test
    void testJDKDynamicProxy() {
        // 创建被代理对象
        BookDAOImpl bookDAO = new BookDAOImpl();
        // 创建动态代理对象
        JDKDynamicProxy proxy = new JDKDynamicProxy(bookDAO);
        // proxyObject就时产生的代理对象，可被
        GeneralDAO proxyObject = (GeneralDAO)proxy.getProxyObject();
        // 使用代理对象调用接口方法，并不会执行被代理对象的方法，而是调用创建代理对象时指定的InvocationHandler接口的invoke方法
        // 调用的方法作为Method参数传给invoke方法
        proxyObject.delete();
    }

    @Test
    void testCGLibDynamicProxy() {
        // 创建被代理对象
        GeneralObject generalObject = new GeneralObject();
        // 创建动态代理对象，并传入被代理对象
        CGLibDynamicProxy cgLibDynamicProxy = new CGLibDynamicProxy(generalObject);
        // 获取产生的代理对象
        GeneralObject proxyObject = (GeneralObject)cgLibDynamicProxy.getProxyObject();
        // 实际调用实现的intercept方法
        proxyObject.delete();
    }
}