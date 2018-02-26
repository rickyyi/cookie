package com.cookie.demo.rmi;

import cn.upenny.common.util.HttpClientUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public class DefaultInvoker<T> implements Invoker {


    private final Class type;

    public DefaultInvoker(Class type) {
        this.type = type;
    }

    @Override
    public Object invoke(Method method, Object ... args) {
        String a = null;
        try {
            RequestMapping rm = method.getAnnotation(RequestMapping.class);
            System.out.println("发送远程请求:" + rm.value()[0] + "-" + type.getName()  + "-" + method+ "-" + Arrays.toString(args));
            a = HttpClientUtils.doGet(rm.value()[0] + (String)args[0], null);
        } catch (Exception e) {
            System.out.println("发送远程请求失败:" + e);
        }
        return a;
    }
}
