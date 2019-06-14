package com.kanghe.notes.common;

import com.kanghe.notes.enums.ResultEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseResult<T extends Object> implements Serializable {

    public Boolean success;

    private T content;

    private String message;

    private Integer code;

    public BaseResult() {
    }

    public BaseResult(Boolean success, T content, Integer code, String message) {
        this.success = success;
        this.content = content;
        this.code = code;
        this.message = message;
    }

    public BaseResult<T> success(T content, String message) {
        this.setSuccess(Boolean.TRUE);
        this.setContent(content);
        this.setCode(ResultEnum.SUCCESS.getCode());
        this.setMessage(message);
        return this;
    }

    public BaseResult<T> failure(T content, Integer code, String message) {
        this.setSuccess(Boolean.FALSE);
        this.setContent(content);
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

}
