package com.kanghe.notes.pattern.factory.simple;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        // 用户本身不在关心生产的过程，而只需要关心这个结果
        // 把用户的需求告诉工厂，创建工厂的过程隐藏了
        SimpleFactory factory = new SimpleFactory();
        System.out.println(factory.getMilk("特仑苏"));
    }

}
