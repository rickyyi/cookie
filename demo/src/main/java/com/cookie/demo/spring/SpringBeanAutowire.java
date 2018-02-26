package com.cookie.demo.spring;

import com.cookie.demo.rmi.DefaultInvoker;
import com.cookie.demo.rmi.factory.JdkProxyFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/24 0024.
 */
@Component
public class SpringBeanAutowire extends SpringAware implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        Class clazz = Class.forName("com.cookie.demo.rmi.service.BaiduService");
        Object object = JdkProxyFactory.getInstance().getProxy(new DefaultInvoker(clazz), new Class[]{clazz});
        getApplicationContext().getAutowireCapableBeanFactory().autowireBean(object);
        ((AutowireCapableBeanFactory)getApplicationContext().getAutowireCapableBeanFactory())
                .autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true);
    }
}
