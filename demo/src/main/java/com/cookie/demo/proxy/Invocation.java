package com.cookie.demo.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/7 0007.
 */
public class Invocation<T> {
    private Object object;
    private Method method;
    private Object[] args;

    public Invocation(Object object, Method method, Object[] args) {
        this.object = object;
        this.method = method;
        this.args = args;
    }

    public T execute() throws Exception {
        return (T) method.invoke(object, args);
    }
}
