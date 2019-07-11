package com.kanghe.notes.pattern.strategy.pay;

import java.util.HashMap;

public class WeiXinPay implements Payment {
    @Override
    public BaseResult<?> pay(String uid, double amount) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("amount", amount);
        return new BaseResult<>().buildSuccess("使用微信支付成功", map);
    }
}
