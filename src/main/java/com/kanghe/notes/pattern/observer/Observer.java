package com.kanghe.notes.pattern.observer;

/**
 * @Author: W_jun1
 * @Date: 2019/7/12 22:31
 * @Description:
 **/
public class Observer {

    public void advice(Event e) {
        System.out.println("触发事件...\n" + e);
    }

}
