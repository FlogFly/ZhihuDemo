package com.framework.common.commonutil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Project:ChintPay
 * Author:dyping
 * Date:2017/6/12 11:08
 */

public class VersionUtil {

    public static String getVersionName(Context context){

        PackageManager manager = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(context.getPackageName(),0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if(info != null){
            return info.versionName;
        }
        return "";
    }
}
