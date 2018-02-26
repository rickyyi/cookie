package com.cookie.demo.spring;

import com.cookie.demo.rmi.DefaultInvoker;
import com.cookie.demo.rmi.factory.JdkProxyFactory;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Administrator on 2017/11/24 0024.
 */
public class MyFactoryBean implements FactoryBean, InitializingBean, DisposableBean {

    private String interfaceName;

    public MyFactoryBean(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public Object getObject() throws Exception {
        Class clazz = Class.forName(interfaceName);
        Object object = JdkProxyFactory.getInstance().getProxy(new DefaultInvoker(clazz), new Class[]{clazz});
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
