package com.kanghe.notes.pattern.proxy.custom;

/**
 * @Author: W_jun1
 * @Date: 2019/7/10 23:05
 * @Description:
 **/
public class Developer implements Programmer {
    @Override
    public void moveBrick() {
        System.out.println("moveBrick");
    }

    @Override
    public void coding() {
        System.out.println("coding");
    }

    @Override
    public void fixBug() {
        System.out.println("fixBug");
    }
}
