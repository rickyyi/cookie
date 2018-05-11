package com.cookie.demo.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * @author cookie
 * @date 2018/5/9 0009
 */
@Component
public class EventBusBuilder implements InitializingBean, ApplicationContextAware, BeanFactoryPostProcessor {

    private EventBus eventBus;
    private ConfigurableListableBeanFactory beanFactory;
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> beansWithAnnotation = beanFactory.getBeansWithAnnotation(EventBusListener.class);
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            Object object = entry.getValue();
            EventBusListener annotation = object.getClass().getAnnotation(EventBusListener.class);
            eventBus.register(annotation.value(), (EventListener)object);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.beanFactory = (ConfigurableListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();
        this.eventBus = applicationContext.getBean(EventBus.class);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }
}
