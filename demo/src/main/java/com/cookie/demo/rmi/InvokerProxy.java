package com.cookie.demo.rmi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author 845477519@qq.com
 * @date 2017/10/26 0026
 */
public class InvokerProxy<T> implements InvocationHandler{

    Invoker invoke;

    public InvokerProxy(Invoker invoke) {
        this.invoke = invoke;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class == method.getDeclaringClass()) {
            return method.invoke(this, args);
        }
        return invoke.execute(method, args);
    }
}
