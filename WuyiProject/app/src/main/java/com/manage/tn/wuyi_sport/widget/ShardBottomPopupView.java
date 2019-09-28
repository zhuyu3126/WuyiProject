package com.manage.tn.wuyi_sport.widget;

import android.content.Context;

import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.manage.tn.wuyi_sport.R;

import io.reactivex.annotations.NonNull;

public class ShardBottomPopupView extends BottomPopupView {
    public ShardBottomPopupView(@NonNull Context context){
        super(context);

    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.shard_bottom_view;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
    }
    // 最大高度为Window的0.85
    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext())*.45f);
    }
}
