package com.manage.tn.wuyi_sport;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.danmo.commonapi.CommonApi;
import com.danmo.commonutil.Utils;
import com.kawa.easyconvey.MyEventBusIndex;
import com.lxj.xpopup.XPopup;
import org.greenrobot.eventbus.EventBus;
public class MyApplication extends MultiDexApplication {
public static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        sAppContext=this;
        EventBus.builder().ignoreGeneratedIndex(false).addIndex(new MyEventBusIndex()).installDefaultEventBus();
        CommonApi.init(this,EventBus.getDefault());//接口工具的创建
        XPopup.setPrimaryColor(getResources().getColor(R.color.colorPrimary));//为弹框框架设置主题
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
