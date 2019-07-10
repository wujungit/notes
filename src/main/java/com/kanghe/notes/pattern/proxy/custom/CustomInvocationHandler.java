package com.kanghe.notes.pattern.proxy.custom;

import java.lang.reflect.Method;

/**
 * @Author: W_jun1
 * @Date: 2019/7/10 20:29
 * @Description:
 **/
public interface CustomInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception;

}
