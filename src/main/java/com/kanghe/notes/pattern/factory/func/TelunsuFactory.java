package com.kanghe.notes.pattern.factory.func;

import com.kanghe.notes.pattern.factory.Milk;
import com.kanghe.notes.pattern.factory.Telunsu;

/**
 * @Author: W_jun1
 * @Date: 2019/7/4 21:16
 * @Description:
 **/
public class TelunsuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
