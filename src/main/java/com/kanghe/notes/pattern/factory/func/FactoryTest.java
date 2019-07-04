package com.kanghe.notes.pattern.factory.func;

/**
 * @Author: W_jun1
 * @Date: 2019/7/4 21:11
 * @Description:
 **/
public class FactoryTest {

    public static void main(String[] args) {
        Factory factory = new MengniuFactory();
        System.out.println(factory.getMilk());
    }

}
