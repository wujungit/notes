package com.kanghe.notes.pattern.strategy;

/**
 * 支付渠道
 */
public interface Payment {

    public static final Payment AliPay = new AliPay();
    public static final Payment WeiXinPay = new WeiXinPay();

    public BaseResult<?> pay(String uid, double amount);

}
