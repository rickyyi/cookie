package com.cookie.demo.event;

/**
 *
 * @author cookie
 * @date 2018/5/7 0007
 */
public interface EventListener<T> {
    void onEvent(Event<T> event);
}
