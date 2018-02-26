package com.cookie.demo.spring;

import com.cookie.demo.rmi.DefaultInvoker;
import com.cookie.demo.rmi.factory.JdkProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/23 0023.
 */
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Autowired
    ApplicationContext applicationContext;

    /*@Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       System.out.println("开始初始化 " + beanName + ":" + bean);
        if ("userController".equals(beanName)) {
            System.out.println("开始初始化userController ");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        //System.out.println("完成初始化" + beanName + ":" + bean);

        Class<?> clazz = bean.getClass();
        if (clazz.getName().indexOf("UserController") != -1) {
            Field[] fields = clazz.getFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                Class clz = field.getType();
                Map<String, Object> map = applicationContext.getBeansOfType(clz);
                if (map.size() == 0) {
                    try {
                        Class cl = Class.forName("com.cookie.demo.rmi.UserService");
                        Object object = JdkProxyFactory.getInstance().getProxy(new DefaultInvoker(clazz), new Class[]{clazz});
                        field.set(bean, object);
                    } catch (Exception e) {
                       System.out.println("手动注入异常");
                    }
                }
            }
        }
        return bean;
    }
*/
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
