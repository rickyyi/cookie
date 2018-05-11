package com.cookie.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author cookie
 * @date 2018/5/7 0007
 */
@Component
@Slf4j
public class EventBus {

    private Lock lock;
    private ThreadPoolExecutor poolExecutor;
    private List<EventListenerSubscriber> subscribers;

    public EventBus() {
        lock = new ReentrantLock();
        subscribers = new ArrayList<>();
    }

    public void register(String eventType, EventListener eventListener) {
        EventListenerSubscriber subscriber = new EventListenerSubscriber(eventType, eventListener);
        lock.lock();
        try {
            subscribers.add(subscriber);
        } finally {
            lock.unlock();
        }
    }

    public void post(Event event) {
        Iterator<EventListenerSubscriber> iterator = subscribers.iterator();
        lock.lock();
        try {
            while (iterator.hasNext()) {
                EventListenerSubscriber subscriber = iterator.next();
                if (event.getEventType().equals(subscriber.getEventType())) {
                    try {
                        subscriber.publish(event);
                    } catch (Exception e) {
                        log.error("{}发生错误：{}", event.getEventType(), e);
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void asyncPost(Event event) {
        // TODO: 2018/5/7 0007 异步执行监听事件
    }
}
