package com.kanghe.notes.pattern.strategy;

import java.util.HashMap;

public class AliPay implements Payment {
    @Override
    public BaseResult<?> pay(String uid, double amount) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("amount", amount);
        return new BaseResult<>().buildSuccess("使用支付宝支付成功", map);
    }
}
