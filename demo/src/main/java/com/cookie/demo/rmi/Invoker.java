package com.cookie.demo.rmi;

import java.lang.reflect.Method;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public interface Invoker<T> {

    Object execute(Method method, Object ... args);

}