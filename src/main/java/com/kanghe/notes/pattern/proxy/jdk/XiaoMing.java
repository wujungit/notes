package com.kanghe.notes.pattern.proxy.jdk;

/**
 * @Author: W_jun1
 * @Date: 2019/7/8 20:42
 * @Description:
 **/
public class XiaoMing implements Person {

    @Override
    public void moveBrick() {
        System.out.println("moveBrick");
    }

    @Override
    public void makeMoney() {
        System.out.println("makeMoney");
    }
}
