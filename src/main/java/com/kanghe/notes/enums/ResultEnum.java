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
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
