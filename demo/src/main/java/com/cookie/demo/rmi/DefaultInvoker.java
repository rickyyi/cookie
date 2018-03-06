package com.cookie.demo.rmi;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
public class DefaultInvoker<T> implements Invoker {


    private final Class<T> type;

    public DefaultInvoker(Class<T> type) {
        this.type = type;
    }

    @Override
    public Object execute(Method method, Object ... args) {
        Map<String, String> map = new HashMap<>();
        try {
            RequestMapping rm = method.getAnnotation(RequestMapping.class);
            map.put("class", method.getDeclaringClass().getName());
            map.put("method", method.getName());
            map.put("annotation", rm.toString());
            map.put("args", Arrays.toString(args));
            ////TODO SOMETHING
        } catch (Exception e) {

        }
        return map;
    }
}
