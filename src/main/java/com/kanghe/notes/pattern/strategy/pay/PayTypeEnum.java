package com.kanghe.notes.pattern.strategy.pay;

import lombok.Getter;

@Getter
public enum PayTypeEnum {

    ALI_PAY(1, "支付宝支付"),
    WEI_XIN_PAY(2, "微信支付"),
    ;

    private int code;
    private String msg;
    private Payment payment;

    PayTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    PayTypeEnum(Payment payment) {
        this.payment = payment;
    }

    public Payment get() {
        return this.payment;
    }

    /**
     * 校验枚举值是否是已定义的
     *
     * @param code
     * @return
     */
    public static boolean isValid(Integer code) {
        if (null != code) {
            for (PayTypeEnum re : values()) {
                if (re.code == code) {
                    return true;
                }
            }
        }
        return false;
    }

}
