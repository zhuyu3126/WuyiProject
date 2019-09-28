package com.danmo.commonapi.bean.home.club;

import java.io.Serializable;
/*
* 用于俱乐部中间类型模块的区分
* */
public class ClubType implements Serializable{
    int type;
    public ClubType(int t){
        type=t;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
