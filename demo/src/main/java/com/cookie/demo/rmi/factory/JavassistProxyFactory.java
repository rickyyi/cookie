package com.cookie.demo.rmi.factory;

import com.cookie.demo.rmi.Invoker;
import com.cookie.demo.rmi.InvokerInvocationHandler;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public class JavassistProxyFactory implements com.cookie.demo.rmi.ProxyFactory {


    private static final JavassistProxyFactory javassistProxyFactory = new JavassistProxyFactory();

    private JavassistProxyFactory() {

    }

    public static JavassistProxyFactory getInstance() {
        return javassistProxyFactory;
    }

    @Override
    public <T> T getProxy(Invoker invoker, Class<?>[] interfaces) {
        try {
            ProxyFactory proxyFactory = new ProxyFactory();
            proxyFactory.setSuperclass(interfaces[0].getClass());
            proxyFactory.setHandler(new MethodHandler() {
                @Override
                public Object invoke(Object self, Method method, Method proceed, Object[] args) throws Throwable {
                    return invoker.execute(method, args);
                }
            });
            return (T) proxyFactory.createClass().newInstance();
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }
}
