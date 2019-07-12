package com.kanghe.notes.pattern.strategy;

import com.alibaba.fastjson.JSON;
import com.kanghe.notes.pattern.adapter.BaseResult;

public class PayStrategyTest {

    public static void main(String[] args) {
        // 下单
        Order order = new Order("1", "ORD001", 324.45);
        // 支付
        BaseResult<?> result = order.pay(PayTypeEnum.WEI_XIN_PAY);
        System.out.println(JSON.toJSONString(result));
    }

}
