package com.demo.splashmodule.view;

import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.demo.splashmodule.R;
import com.demo.splashmodule.contract.SplashContract;
import com.demo.splashmodule.entity.SplashImgEntity;
import com.demo.splashmodule.model.SplashModel;
import com.demo.splashmodule.presenter.SplashPresenter;
import com.framework.appinit.arouter.ARouterUtil;
import com.framework.appinit.imgload.ImageLoadUtil;
import com.framework.common.commonview.BaseFrameActivity;
import com.framework.coremodel.http.CommonObserver;
import com.jaeger.library.StatusBarUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


@Route(path = "/splashmodule/main")
public class SplashActivity extends BaseFrameActivity<SplashPresenter, SplashModel> implements SplashContract.View {

    ImageView splashIV;

    @Override
    public void setRootView() {
        setContentView(R.layout.splash_activity);
        splashIV = findViewById(R.id.splash_image);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
        ImageView logo = findViewById(R.id.logo);
        fixBackgroundRepeat(logo);

    }

    @Override
    public void initData() {
        super.initData();
       // mPresenter.getSplashImage();
    }


    @Override
    public void loadSplashImage(SplashImgEntity splashImgEntity) {
        ImageLoadUtil.getmImageLoader().loadImage(this, splashIV, splashImgEntity.getImg());
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new CommonObserver<Long>(mDialog) {
                    @Override
                    protected void onError(String s) {

                    }

                    @Override
                    protected void onSuccess(Long aLong) {
                        Log.v("dyp","开始跳转了。。。");

                        ARouterUtil.normalNavigation("/homemodule/home");
                    }

                    @Override
                    public void doOnSubscribe(Disposable d) {
                        super.doOnSubscribe(d);
                        mPresenter.mRxManager.add(d);
                    }
                });
    }

    public static void fixBackgroundRepeat(View view) {
        Drawable bg = view.getBackground();
        if (bg != null) {
            if (bg instanceof BitmapDrawable) {
                BitmapDrawable bmp = (BitmapDrawable) bg;
                bmp.mutate(); // make sure that we aren't sharing state anymore
                bmp.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            }
        }
    }


}
