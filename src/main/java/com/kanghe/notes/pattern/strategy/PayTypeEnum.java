package com.kanghe.notes.pattern.strategy;

import lombok.Getter;

@Getter
public enum PayTypeEnum {

    ALI_PAY(new AliPay()),
    WEI_XIN_PAY(new WeiXinPay()),
    ;

    private Payment payment;

    PayTypeEnum(Payment payment) {
        this.payment = payment;
    }

    public Payment get() {
        return this.payment;
    }

}
