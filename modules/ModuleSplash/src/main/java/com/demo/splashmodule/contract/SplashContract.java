package com.demo.splashmodule.contract;

import com.demo.splashmodule.entity.SplashImgEntity;
import com.framework.common.commonmvp.BaseModel;
import com.framework.common.commonmvp.BasePresenter;
import com.framework.common.commonmvp.BaseView;

import io.reactivex.Observable;


/**
 * Created by dyping on 2018/3/30.
 */

public interface SplashContract {

    interface Model extends BaseModel{
        Observable<SplashImgEntity> getSplashImage();
    }

    interface  View extends BaseView{
        void loadSplashImage(SplashImgEntity splashImgEntity);
    }

    abstract class Presenter extends BasePresenter<Model,View>{
        public abstract void getSplashImage();
    }

}
