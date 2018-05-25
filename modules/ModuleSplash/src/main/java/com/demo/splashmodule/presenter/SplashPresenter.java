package com.demo.splashmodule.presenter;

import com.demo.splashmodule.contract.SplashContract;
import com.demo.splashmodule.entity.SplashImgEntity;
import com.framework.appinit.arouter.ARouterUtil;
import com.framework.coremodel.http.CommonObserver;

import io.reactivex.disposables.Disposable;

/**
 * Created by dyping on 2018/3/30.
 */

public class SplashPresenter extends SplashContract.Presenter {


    @Override
    public void getSplashImage() {
        mModel
                .getSplashImage()
                .subscribe(new CommonObserver<SplashImgEntity>(mDialog) {
                    @Override
                    protected void onError(String var1) {
                        ARouterUtil.normalNavigation("/homemodule/home");
                    }

                    @Override
                    protected void onSuccess(SplashImgEntity var1) {
                        mView.loadSplashImage(var1);
                    }

                    @Override
                    public void doOnSubscribe(Disposable d) {
                        super.doOnSubscribe(d);
                        mRxManager.add(d);
                    }
                });

    }
}
