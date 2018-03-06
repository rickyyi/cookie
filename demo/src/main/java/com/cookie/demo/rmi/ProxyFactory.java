package com.cookie.demo.rmi;

/**
 * Created by 845477519@qq.com on 2017/10/27 0027.
 */
public interface ProxyFactory {

    public <T> T getProxy(Invoker invoker, Class<?>[] interfaces);

}
