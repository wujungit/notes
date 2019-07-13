package com.kanghe.notes.pattern.adapter;

/**
 * 适配器模式
 * 兼容
 */
public class LoginTest {

    public static void main(String[] args) {
        LoginForThirdService service = new LoginForThirdService();
        // 不改变原来的代码，也要能够兼容新的需求
        // 还可以再加一层策略模式
        service.loginForWeiXin("123456asdfgh");
    }

}
