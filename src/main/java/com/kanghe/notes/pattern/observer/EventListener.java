package com.kanghe.notes.pattern.observer;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: W_jun1
 * @Date: 2019/7/12 22:43
 * @Description:
 **/
public class EventListener {

    private Map<Enum, Event> events = new HashMap<>();

    public void addListener(Enum eventType, Object target, Method callback) {
        // 注册事件
        // 用反射调用这个方法
        this.events.put(eventType, new Event(target, callback));
    }

    private void trigger(Event e) {
        e.setSource(this);
        e.setTime(new Date());
        try {
            e.getCallback().invoke(e.getTarget(), e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        trigger(this.events.get(call).setTrigger(call.toString()));
    }

}
