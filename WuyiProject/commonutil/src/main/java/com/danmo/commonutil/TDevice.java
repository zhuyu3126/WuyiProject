package com.danmo.commonutil;


import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

public class TDevice {

    public static int getVersionCode(Context context) {
        try {
            String packageName = context.getPackageName();
            return context
                    .getPackageManager()
                    .getPackageInfo(packageName, 0)
                    .versionCode;
        } catch (PackageManager.NameNotFoundException ex) {
            return 0;
        }
    }

    /**
     * 获得版本名称
     */
    public static String getVerName(Context context) {
        String verName = "";
        String packageName = context.getPackageName();
        try {
            verName = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("版本名称获取异常", e.getMessage());
        }
        return verName;
    }

}
