package com.cookie.demo.rmi.factory;

import com.cookie.demo.rmi.Invoker;
import com.cookie.demo.rmi.InvokerProxy;
import com.cookie.demo.rmi.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public class JdkProxyFactory implements ProxyFactory {

    @Override
    public <T> T getProxy(Invoker invoker, Class<?>[] interfaces) {
        InvocationHandler handler = new InvokerProxy(invoker);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), interfaces, handler);
    }
}
