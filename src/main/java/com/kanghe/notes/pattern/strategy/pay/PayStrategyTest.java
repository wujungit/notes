package com.kanghe.notes.pattern.strategy.pay;

import com.alibaba.fastjson.JSON;

public class PayStrategyTest {

    public static void main(String[] args) {
        Order order = new Order("1", "ORD001", 324.45);
        BaseResult<?> result = order.pay(PayTypeEnum.WEI_XIN_PAY);
        System.out.println(JSON.toJSONString(result));
    }

}
