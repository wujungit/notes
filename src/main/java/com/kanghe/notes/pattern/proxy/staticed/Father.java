package com.kanghe.notes.pattern.proxy.staticed;

public class Father {

    private Son son;

    // 没办法扩展
    public Father(Son son) {
        this.son = son;
    }

    public void findLove() {
        this.son.findLove();
    }

}
