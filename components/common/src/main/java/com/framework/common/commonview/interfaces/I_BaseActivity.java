package com.framework.common.commonview.interfaces;

/**
 * Created by willy on 17/1/19.
 */

public interface I_BaseActivity {

    //设置root界面
    void setRootView();

    //绑定界面控件
    void onBind();

    //初始化数据
    void initData();

    //网络访问获取数据
    void onLoadData();

    //初始化控件
    void initWidget();



}
