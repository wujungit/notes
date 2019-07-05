package com.kanghe.notes.pattern.singleton.lazy;

/**
 * 单例：双重校验锁
 */
public class LazyOne {

    private static LazyOne instance = null;

    private LazyOne() {
    }

    public static LazyOne getInstance() {
        if (instance == null) {
            synchronized (LazyOne.class) {
                if (instance == null) {
                    instance = new LazyOne();
                }
            }
        }
        return instance;
    }

}
