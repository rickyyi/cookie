package com.cookie.demo.rmi;

import com.cookie.demo.rmi.factory.JdkProxyFactory;
import com.cookie.demo.rmi.service.TaoBaoService;
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
        TaoBaoService taoBaoService =  test.get("com.cookie.demo.rmi.UserService");
    }


    public <T> T get(String className) throws Exception{
        Class clazz = Class.forName(className);
        return JdkProxyFactory.getInstance().getProxy(new DefaultInvoker(clazz), new Class[]{clazz});
    }

}
