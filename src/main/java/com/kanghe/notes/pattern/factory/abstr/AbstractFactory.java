package com.kanghe.notes.pattern.factory.abstr;

import com.kanghe.notes.pattern.factory.Milk;

/**
 * @Author: W_jun1
 * @Date: 2019/7/4 21:24
 * @Description: 抽象工厂
 * 用户的主入口
 * 公共的逻辑写到一起，易于扩展
 **/
public abstract class AbstractFactory {

    public abstract Milk getTelunsu();

    public abstract Milk getMengniu();

}
