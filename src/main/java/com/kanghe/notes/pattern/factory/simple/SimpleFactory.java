package com.kanghe.notes.pattern.factory.simple;

import com.kanghe.notes.pattern.factory.Mengniu;
import com.kanghe.notes.pattern.factory.Milk;
import com.kanghe.notes.pattern.factory.Telunsu;

public class SimpleFactory {

    public Milk getMilk(String name) {
        if ("特仑苏".equals(name)) {
            return new Telunsu();
        } else if ("蒙牛".equals(name)) {
            return new Mengniu();
        }
        return null;
    }

}

