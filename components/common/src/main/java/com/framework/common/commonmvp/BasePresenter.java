package com.framework.common.commonmvp;

import android.app.Dialog;

import com.framework.common.commonrx.RxManager;

/**
 * Created by dyping on 2018/3/29.
 */

public abstract class BasePresenter<M, V> {
    public M mModel;
    public V mView;
    public Dialog mDialog;
    public RxManager mRxManager = new RxManager();

    public void attachVM(V v, M m) {
        this.mModel = m;
        this.mView = v;
    }

    public void attchDialog(Dialog dialog) {
        this.mDialog = dialog;
    }


    public void detachVM() {
        mRxManager.clear();
        mView = null;
        mModel = null;
        mDialog = null;
    }

}