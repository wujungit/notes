package com.kanghe.notes.exception;

import com.alibaba.fastjson.JSONObject;
import com.kanghe.notes.common.BaseResult;
import com.kanghe.notes.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 统一异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Value("${spring.application.name}")
    private String srvName;

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public BaseResult<?> handleRuntimeException(RuntimeException e) {
        log.error("service name: {}, runtimeException: {}", srvName, e);
        return new BaseResult<>().failure(new HashMap<>(), ResultEnum.ERROR.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({BuzException.class})
    public BaseResult<?> handleBuzException(BuzException e) {
        log.error("service name: {}, buzException: {}", srvName, e);
        Integer code = e.getCode();
        if (code == null) {
            code = ResultEnum.ERROR.getCode();
        }
        return new BaseResult<>().failure(new HashMap<>(), code, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult<?> validationBodyException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError p : errors) {
                FieldError fieldError = (FieldError) p;
                log.error("service name: {}, validException: object={},field={},errorMessage={}",
                        srvName, fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
                return new BaseResult<>().failure(new HashMap<>(), ResultEnum.INVALID_PARAM.getCode(), fieldError.getDefaultMessage());
            }
        }
        return new BaseResult<>(Boolean.FALSE, new HashMap<>(), ResultEnum.ERROR.getCode(), e.getMessage());
    }

}
