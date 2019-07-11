package com.kanghe.notes.pattern.strategy.pay;

import lombok.Getter;

@Getter
public enum PayStateEnum {

    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
    PROCESSING(-1, "处理中"),
    ;

    private int code;
    private String msg;

    PayStateEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 校验枚举值是否是已定义的
     *
     * @param code
     * @return
     */
    public static boolean isValid(Integer code) {
        if (null != code) {
            for (PayStateEnum re : values()) {
                if (re.code == code) {
                    return true;
                }
            }
        }
        return false;
    }

}
