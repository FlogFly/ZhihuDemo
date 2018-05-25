package com.demo.donation.homemodule.api;

import com.demo.donation.homemodule.entity.ThemeListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by dyping on 2018/4/4.
 */

public interface ThemeApi {

    //主题日报列表查看
    @GET("themes")
    Observable<ThemeListBean> getThemeList();


}
