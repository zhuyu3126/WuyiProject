package com.danmo.commonapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import com.danmo.commonapi.api.home.HomeImpl;
import com.danmo.commonapi.base.Constant;
import com.danmo.commonapi.bean.login.OAuth;
import com.danmo.commonutil.DebugUtil;
import com.danmo.commonutil.log.Config;
import com.danmo.commonutil.log.Logger;

import org.greenrobot.eventbus.EventBus;


public class CommonApi {
    private static Context mContext;
    public static HomeImpl homeImple;

    //--- 单例 -----------------------------------------------------------------------------------
    private volatile static CommonApi mCommonApi;

    private CommonApi() {
    }

    public static CommonApi getSingleInstance() {
        if (null == mCommonApi) {
            synchronized (CommonApi.class) {
                if (null == mCommonApi) {
                    mCommonApi = new CommonApi();
                }
            }
        }
        return mCommonApi;
    }

    //--- 初始化 ---------------------------------------------------------------------------------
    public static CommonApi init(@NonNull Context context,  @Nullable EventBus eventBus) {
        initLogger(context);
        initImplement(context,eventBus);
        return getSingleInstance();
    }

    private static void initLogger(@NonNull Context context) {
        // 在 debug 模式输出日志， release 模式自动移除
        if (DebugUtil.isInDebug(context)) {
            Logger.init("wuyi").setLevel(Config.LEVEL_FULL);
        } else {
            Logger.init("wuyi").setLevel(Config.LEVEL_NONE);
        }
    }

    private static void initImplement(Context context,EventBus eventBus) {
        mContext = context;
        try {
            homeImple=new HomeImpl(context, Constant.BASE_URL, Constant.PARSE_GSON,eventBus);
                  } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
