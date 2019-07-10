package com.kanghe.notes.pattern.proxy.custom;

import java.lang.reflect.Method;

/**
 * @Author: W_jun1
 * @Date: 2019/7/10 23:11
 * @Description:
 **/
public class Outsourcing implements CustomInvocationHandler {

    private Programmer target;

    public Object getInstance(Programmer target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return CustomProxy.newProxyInstance(new CustomClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        method.invoke(this.target, args);
        System.out.println("invoke");
        return null;
    }
}
