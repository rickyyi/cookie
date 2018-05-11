package com.cookie.demo.event;

import lombok.Data;

/**
 *
 * @author cookie
 * @date 2018/5/8 0008
 */
@Data
public class EventListenerSubscriber {
    private String eventType;
    private EventListener eventListener;

    public EventListenerSubscriber(String eventType, EventListener eventListener) {
        this.eventType = eventType;
        this.eventListener = eventListener;
    }

    public void publish(Event event) throws Exception {
        eventListener.onEvent(event);
    }
}
