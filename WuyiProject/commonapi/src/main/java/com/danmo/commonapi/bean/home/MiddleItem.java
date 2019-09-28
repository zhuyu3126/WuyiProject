package com.danmo.commonapi.bean.home;

import java.io.Serializable;
import java.util.List;
/*
* RefreshRecyclerFragment midll类型
* */
public class MiddleItem<T> implements Serializable {
    List<T> data;
    public MiddleItem(List<T> data){
        this.data=data;
    }
    public MiddleItem(){

    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
