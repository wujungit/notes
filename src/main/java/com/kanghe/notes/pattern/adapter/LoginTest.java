package com.kanghe.notes.pattern.adapter;

/**
 * 适配器模式
 */
public class LoginTest {

    public static void main(String[] args) {
        LoginForThirdService service = new LoginForThirdService();
        // 还可以再加一层策略模式
        service.loginForWeiXin("123456asdfgh");
    }

}
