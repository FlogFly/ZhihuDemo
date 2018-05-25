package com.framework.common.commonview;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framework.common.commonview.interfaces.I_BaseActivity;
import com.framework.common.commonview.interfaces.I_BroadcastReg;
import com.framework.common.commonview.interfaces.I_DialogView;
import com.framework.common.commonview.interfaces.I_SkipActivity;


/**
 * Created by willy on 17/1/19.
 */

public abstract class BaseActivity extends AppCompatActivity implements I_BaseActivity, I_BroadcastReg, I_SkipActivity,I_DialogView {

    protected BaseFragment currentBaseFragment;

    public Activity aty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aty = this;
        setRootView();
        onBind();
        initDialog();
        initData();
        onLoadData();
        initWidget();
        registerBroadcast();

    }

    @Override
    public void initDialog() {

    }

    @Override
    public void onBind() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        unRegisterBroadcast();
        super.onDestroy();
    }

    @Override
    public abstract void setRootView();

    @Override
    public void initData() {

    }

    @Override
    public void onLoadData() {

    }

    @Override
    public void initWidget() {

    }

    @Override
    public void registerBroadcast() {

    }

    @Override
    public void unRegisterBroadcast() {

    }

    @Override
    public void skipActivity(Activity aty, Class<?> cls) {
        showActivity(aty, cls);
        aty.finish();
    }

    @Override
    public void skipActivity(Activity aty, Intent it) {
        showActivity(aty, it);
        aty.finish();
    }

    @Override
    public void skipActivity(Activity aty, Class<?> cls, Bundle extras) {
        showActivity(aty, cls, extras);
        aty.finish();
    }

    @Override
    public void showActivity(Activity aty, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }

    @Override
    public void showActivity(Activity aty, Intent it) {
        aty.startActivity(it);
    }

    @Override
    public void showActivity(Activity aty, Class<?> cls, Bundle extras) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }

    public void changeFragment(int resView, BaseFragment targetFragment) {

        if (targetFragment.equals(currentBaseFragment)) {
            return;
        }

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction.add(resView, targetFragment, targetFragment.getClass().getName());
        }

        if (targetFragment.isHidden()) {
            transaction.show(targetFragment);
            targetFragment.onChange();
        }

        if (currentBaseFragment != null && !currentBaseFragment.isHidden()) {
            transaction.hide(currentBaseFragment);
        }

        currentBaseFragment = targetFragment;
        transaction.commit();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1)//非默认值
            getResources();
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();
            //设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                createConfigurationContext(newConfig);
            } else {
                res.updateConfiguration(newConfig, res.getDisplayMetrics());
            }
        }
        return res;
    }
}
