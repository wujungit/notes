package com.kanghe.notes.pattern.strategy;

import com.kanghe.notes.pattern.adapter.BaseResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    // 完美的解决了需要再代码中写switch的过程
    public BaseResult<?> pay(PayTypeEnum payTypeEnum) {
        Payment payment = payTypeEnum.get();
        return payment.pay(this.uid, this.amount);
    }

}
