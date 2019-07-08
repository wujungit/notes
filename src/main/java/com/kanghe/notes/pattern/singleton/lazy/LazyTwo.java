package com.kanghe.notes.pattern.singleton.lazy;

/**
 * 单例：匿名内部类
 * 使用LazyThree的时候，会先初始化内部类；如果没有使用的话，内部类是不加载的。
 * 序列化：把内存中的状态通过转换成字节码的形式，从而转换一个IO流，写入到其他地方（磁盘、网络IO），把内存中的状态给永久保存下来了。
 * 反序列化：将已经持久化的字节码内容，转换为IO流，通过IO流的读取，进而将读取的内容转换为Java对象，在转换过程中会重新创建对象。
 * 反序列化时，会导致单例破坏。
 */
public class LazyTwo {

    private static boolean initialized = false;

    private LazyTwo() {
        synchronized (this) {
            if (!initialized) {
                initialized = true;
            } else {
                throw new RuntimeException("单例被侵犯！");
            }
        }
    }

    public static LazyTwo getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final LazyTwo instance = new LazyTwo();
    }

}
