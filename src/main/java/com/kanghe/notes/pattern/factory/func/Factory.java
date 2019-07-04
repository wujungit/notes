package com.kanghe.notes.pattern.factory.func;

import com.kanghe.notes.pattern.factory.Milk;

/**
 * @Author: W_jun1
 * @Date: 2019/7/4 21:08
 * @Description: 工厂方法
 * 工厂必然具有生产产品的技能，统一的产品出口
 **/
public interface Factory {

    Milk getMilk();

}
