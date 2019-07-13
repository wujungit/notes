package com.kanghe.notes.pattern.observer;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: W_jun1
 * @Date: 2019/7/12 22:37
 * @Description:
 **/
public class Event {
    /**
     * 事件源
     */
    private Object source;

    /**
     * 通知目标
     */
    private Object target;

    /**
     * 回调
     */
    private Method callback;

    /**
     * 触发
     */
    private String trigger;

    /**
     * 时间
     */
    private Date time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public Event setTarget(Object target) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public Event setTime(Date time) {
        this.time = time;
        return this;
    }
}
