package com.kanghe.notes.pattern.proxy.custom;

/**
 * @Author: W_jun1
 * @Date: 2019/7/10 22:58
 * @Description:
 **/
public class CustomProxyTest {

    public static void main(String[] args) {
        Programmer instance = (Programmer) new Outsourcing().getInstance(new Developer());
        instance.moveBrick();
        instance.coding();
        instance.fixBug();
    }

}
