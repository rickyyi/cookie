package com.cookie.demo.event;

import lombok.Data;

/**
 *
 * @author cookie
 * @date 2018/5/7 0007
 */
@Data
public class Event<T> {
    private String eventType;
    private T message;

    public Event(String eventType, T message) {
        this.eventType = eventType;
        this.message = message;
    }
}
