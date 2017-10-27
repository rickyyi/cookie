package com.cookie.demo.rmi;

import com.cookie.demo.rmi.factory.JavassistProxyFactory;
import com.cookie.demo.rmi.factory.JdkProxyFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by 845477519@qq.com on 2017/10/26 0026.
 */
@Component
public class Test implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        UserService userService =  test.get("com.cookie.demo.rmi.UserService");
        System.out.print(userService.getUser(1L));
    }


    public <T> T get(String className) throws Exception{
        Class clazz = Class.forName(className);
        return JdkProxyFactory.getInstance().getProxy(new DefaultInvoker(clazz), new Class[]{clazz});
    }

}
