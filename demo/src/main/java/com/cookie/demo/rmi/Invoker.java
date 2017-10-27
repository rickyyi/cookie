package com.cookie.demo.rmi;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public interface Invoker<T> {
    Object invoke(String method, Object... args);
}