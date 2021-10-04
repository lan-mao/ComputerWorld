package top.lan_mao.computer_world.spring.proxy;

import top.lan_mao.computer_world.spring.service.DoSomethingService;

/**
 * Create Date 2020/09/08 17:02
 * Created by lan-mao.top
 * TODO
 * - 对代理类增强
 */

public class ServiceProxyByStatic implements DoSomethingService {
    private DoSomethingService target;

    public ServiceProxyByStatic() {
    }

    public ServiceProxyByStatic(DoSomethingService target) {
        this.target = target;
    }

    @Override
    public String doSomething() {
        return target.doSomething().toUpperCase();
    }

    @Override
    public String doNothing() {
        return null;
    }

    @Override
    public String doError() {
        return 1/0+"";
    }
}
