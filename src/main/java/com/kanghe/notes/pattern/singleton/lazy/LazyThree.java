package com.kanghe.notes.pattern.singleton.lazy;

/**
 * 单例：匿名内部类
 * 使用LazyThree的时候，会先初始化内部类；如果没有使用的话，内部类是不加载的。
 */
public class LazyThree {

    private LazyThree() {
    }

    public static LazyThree getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final LazyThree instance = new LazyThree();
    }

}
