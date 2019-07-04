package com.kanghe.notes.pattern.factory.abstr;

/**
 * @Author: W_jun1
 * @Date: 2019/7/4 21:28
 * @Description: 抽象工厂模式
 * 在Spring中应用最为广泛的一种设计模式
 **/
public class AbstractFactoryTest {

    public static void main(String[] args) {
        MilkFactory factory = new MilkFactory();
        System.out.println(factory.getMengniu());
    }

}
