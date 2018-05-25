package com.demo.splashmodule.model;

import com.allen.library.RxHttpUtils;
import com.allen.library.interceptor.Transformer;
import com.demo.splashmodule.api.SplashApi;
import com.demo.splashmodule.contract.SplashContract;
import com.demo.splashmodule.entity.SplashImgEntity;

import io.reactivex.Observable;


/**
 * Created by dyping on 2018/3/30.
 */

public class SplashModel implements SplashContract.Model{


    @Override
    public Observable<SplashImgEntity> getSplashImage() {
        return RxHttpUtils.getInstance().createApi(SplashApi.class)
                .getSplashImg()
                .compose(Transformer.<SplashImgEntity>switchSchedulers());

    }
}
