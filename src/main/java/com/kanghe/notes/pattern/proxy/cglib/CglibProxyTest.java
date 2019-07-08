package com.kanghe.notes.pattern.proxy.cglib;

/**
 * @Author: W_jun1
 * @Date: 2019/7/8 22:07
 * @Description:
 **/
public class CglibProxyTest {

    public static void main(String[] args) {
        XiaoHong instance = (XiaoHong) new CglibProxy().getInstance(XiaoHong.class);
        instance.moveBrick();
        instance.makeMoney();
    }

}
