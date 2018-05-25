package com.framework.appinit;

import android.app.Application;

import com.framework.appinit.arouter.ARouterUtil;
import com.framework.appinit.imgload.ImageLoadUtil;
import com.framework.appinit.imgload.glide.GlideImageLoader;
import com.framework.appinit.logger.LoggerUtil;
import com.framework.appinit.refreshlayout.RefreshLayoutUtil;

/**
 * Created by dyping on 2018/3/28.
 */

public class AppInitUtil {

    public static void init(Application application) {

        ARouterUtil.init(application);
        RefreshLayoutUtil.init();
        LoggerUtil.init(application);
        ImageLoadUtil.init(new GlideImageLoader());

    }
}
