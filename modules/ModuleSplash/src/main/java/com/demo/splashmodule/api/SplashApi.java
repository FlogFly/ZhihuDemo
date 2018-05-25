package com.demo.splashmodule.api;

import com.demo.splashmodule.entity.SplashImgEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SplashApi {
    /**
     * 获取启动界面图像
     * @return
     */
    @GET("start-image/1080*1776")
    Observable<SplashImgEntity> getSplashImg();


}
