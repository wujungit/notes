package com.kanghe.notes.pattern.decorate;

/**
 * @Author: W_jun1
 * @Date: 2019/7/12 21:38
 * @Description: 装饰器模式
 * 为了某个实现类在不修改原始类的基础上进行动态的覆盖或者增加方法
 * 该实现类要保持跟原有类的层级关系
 * 装饰器模式实际上是一种非常特殊的适配器模式
 **/
public class LoginTest {

    public static void main(String[] args) {
        // 原来的功能依旧保留，新的功能同样也可以用
        ILoginForThirdService loginForThirdService = new LoginForThirdService(new LoginService());
        loginForThirdService.loginForQQ("123abc");
    }

}
