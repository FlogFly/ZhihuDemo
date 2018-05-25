package com.framework.common.commonutil;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * Project:ChintH5
 * Author:dyping
 * Date:2017/3/14 10:52
 */

public class WebViewUtil {
    public static void initWebView(WebView webView){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setWebContentsDebuggingEnabled(true);
        }

        WebSettings webSettings = webView.getSettings();

        //设置支持js
        webSettings.setJavaScriptEnabled(true);

        webView.loadData("","text/html","UTF-8");
        // 设置可以支持缩放
        webSettings.setSupportZoom(false);
        // 设置出现缩放工具
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);
        webSettings.setUseWideViewPort(false);

        //自适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);

        //设置字体
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);

        //webView.setInitialScale(250);
        webSettings.setSavePassword(false);
    }




    public static void setInitailScale(Context context,WebView webView){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        if(width > 650)
        {
            webView.setInitialScale(190);
        }else if(width > 520)
        {
            webView.setInitialScale(160);
        }else if(width > 450)
        {
            webView.setInitialScale(140);
        }else if(width > 300)
        {
            webView.setInitialScale(120);
        }else
        {
            webView.setInitialScale(100);
        }
    }

}
