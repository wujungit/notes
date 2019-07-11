package com.kanghe.notes.pattern.strategy.pay;

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

    public BaseResult<?> pay(PayTypeEnum payTypeEnum) {
        return payment.pay(this.uid, this.amount);
    }

}
