package com.kanghe.notes.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
    INVALID_PARAM(1001, "参数不合法"),
    DATA_NOT_FOUND(1002, "数据不存在"),
    DATA_HAS_EXISTS(1003, "数据已存在"),
    OPERATION_ERROR(1004, "操作有误"),
    SEND_MQ_ERROR(1005, "发送MQ失败"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
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
            for (ResultEnum re : values()) {
                if (re.code.equals(code)) {
                    return true;
                }
            }
        }
        return false;
    }

}
