package com.kanghe.notes.pattern.singleton.hungry;

/**
 * 单例：饿汉式
 */
public class Hungry {

    private static final Hungry instance = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return instance;
    }

}
