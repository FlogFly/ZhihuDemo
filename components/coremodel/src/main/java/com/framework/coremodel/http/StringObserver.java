package com.framework.coremodel.http;

import android.app.Dialog;

import com.allen.library.base.BaseStringObserver;
import com.allen.library.utils.ToastUtils;

import io.reactivex.disposables.Disposable;

public abstract class StringObserver extends BaseStringObserver {
    private Dialog mProgressDialog;

    public StringObserver() {
    }

    public StringObserver(Dialog progressDialog) {
        this.mProgressDialog = progressDialog;
    }

    protected abstract void onError(String var1);

    protected abstract void onSuccess(String var1);

    public abstract void doOnSubscribe(Disposable d);

    public void doOnError(String errorMsg) {
        this.dismissLoading();
        if(!this.isHideToast()) {
            ToastUtils.showToast(errorMsg);
        }

        this.onError(errorMsg);
    }

    public void doOnNext(String string) {
        this.onSuccess(string);
    }

    public void doOnCompleted() {
        this.dismissLoading();
    }

    private void dismissLoading() {
        if(this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }

    }
}
