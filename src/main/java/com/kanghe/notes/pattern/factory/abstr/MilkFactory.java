package com.kanghe.notes.pattern.factory.abstr;

import com.kanghe.notes.pattern.factory.Mengniu;
import com.kanghe.notes.pattern.factory.Milk;
import com.kanghe.notes.pattern.factory.Telunsu;

/**
 * @Author: W_jun1
 * @Date: 2019/7/4 21:31
 * @Description:
 **/
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getTelunsu() {
        return new Telunsu();
    }

    @Override
    public Milk getMengniu() {
        return new Mengniu();
    }
}
