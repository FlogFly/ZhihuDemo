package com.framework.appinit.arouter;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.framework.appinit.BuildConfig;

/**
 * Created by dyping on 2018/3/28.
 */

public class ARouterUtil {

    public static void init(Application application) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
    }

    public static void normalNavigation(String path) {
        ARouter.getInstance()
                .build(path)
                .navigation();
    }

    public static void navigationWithParams(String path, Bundle bundle) {
        ARouter.getInstance()
                .build(path)
                .withBundle("bundle", bundle)
                .navigation();
    }

    public static void naviationByUri(Uri uri) {
        ARouter.getInstance().build(uri).navigation();
    }



}
