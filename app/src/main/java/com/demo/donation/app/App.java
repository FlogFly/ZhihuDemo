package com.demo.donation.app;

import android.app.Application;

import com.allen.library.RxHttpUtils;
import com.framework.appinit.AppInitUtil;


/**
 * Created by dyping on 2018/3/28.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppInitUtil.init(this);

        //Retrofit的全局配置
        RxHttpUtils.init(this);
        RxHttpUtils.getInstance()
                .config()
                .setBaseUrl("http://news-at.zhihu.com/api/4/")
                .setCookie(true)
                .setReadTimeout(15)
                .setWriteTimeout(15)
                .setConnectTimeout(15)
                .setLog(true);


    }
}
