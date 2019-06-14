package com.kanghe.notes.exception;

import com.kanghe.notes.enums.ResultEnum;
import lombok.Getter;

/**
 * 业务异常
 */
@Getter
public class BuzException extends RuntimeException {

    private Integer code;

    public BuzException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public BuzException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}
