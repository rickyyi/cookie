package com.cookie.demo.rmi;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public class DefaultInvoker<T> implements Invoker {


    private final Class<T> type;

    public DefaultInvoker(Class<T> type) {
        this.type = type;
    }

    @Override
    public Object invoke(String method, Object ... args) {
        try {
            Method m = type.getMethod(method, Long.class);
            RequestMapping rm = m.getAnnotation(RequestMapping.class);
            System.out.println("发送远程请求:" + rm.value()[0] + "-" + type.getName()  + "-" + method+ "-" + Arrays.toString(args));
        } catch (Exception e) {

        }
        return "结果";
    }
}
