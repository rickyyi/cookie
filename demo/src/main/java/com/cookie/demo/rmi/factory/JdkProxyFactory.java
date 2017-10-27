package com.cookie.demo.rmi.factory;

import com.cookie.demo.rmi.Invoker;
import com.cookie.demo.rmi.InvokerInvocationHandler;
import com.cookie.demo.rmi.ProxyFactory;

import java.lang.reflect.Proxy;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public class JdkProxyFactory implements ProxyFactory {

    private static final JdkProxyFactory jdkProxyFactory = new JdkProxyFactory();

    private JdkProxyFactory() {

    }

    @Override
    public <T> T getProxy(Invoker invoker, Class<?>[] interfaces) {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), interfaces, new InvokerInvocationHandler(invoker));
    }

    public static JdkProxyFactory getInstance() {
        return jdkProxyFactory;
    }
}
