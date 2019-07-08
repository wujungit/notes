package com.kanghe.notes.pattern.proxy.staticed;

/**
 * 动态代理：拿到目标类的引用，并且能够调用到目标类的业务方法；
 * 静态代理：在代理之前，所有的东西都是已知的；
 * 动态代理：在代理之前，所有的东西都是未知的；
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }

}
