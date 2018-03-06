package com.cookie.demo.rmi;

import com.cookie.demo.rmi.factory.JdkProxyFactory;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author 845477519@qq.com
 * @date 2018/3/6 0006
 */
public class ProxyFactoryBean<T> implements FactoryBean, InitializingBean {

    private Object instanceObject;

    private Class<?> objectInterface;

    private ProxyFactory proxyFactory = new JdkProxyFactory();

    public ProxyFactoryBean(Class<?> objectInterface) {
        this.objectInterface = objectInterface;
    }

    @Override
    public T getObject() throws Exception {
        return (T) instanceObject;
    }

    @Override
    public Class<?> getObjectType() {
        return objectInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.instanceObject = proxyFactory.getProxy(new DefaultInvoker(objectInterface), new Class[]{objectInterface});
    }
}
