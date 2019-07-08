package com.kanghe.notes.pattern.proxy.jdk;

/**
 * @Author: W_jun1
 * @Date: 2019/7/8 20:50
 * @Description:
 **/
public class JdkProxyTest {

    public static void main(String[] args) {
        Person instance = (Person) new JdkProxy().getInstance(new XiaoMing());
        instance.moveBrick();
        instance.makeMoney();
    }

}
