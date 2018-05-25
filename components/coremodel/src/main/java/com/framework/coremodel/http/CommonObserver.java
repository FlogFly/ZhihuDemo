package com.framework.coremodel.http;

import android.app.Dialog;

import com.allen.library.base.BaseObserver;
import com.allen.library.utils.ToastUtils;

import io.reactivex.disposables.Disposable;

public abstract class CommonObserver<T> extends BaseObserver<T> {
    private Dialog mProgressDialog;

    public CommonObserver() {
    }

    public CommonObserver(Dialog progressDialog) {
        this.mProgressDialog = progressDialog;
    }

    protected abstract void onError(String var1);

    protected abstract void onSuccess(T var1);

    public void doOnSubscribe(Disposable d) {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.show();
        }
    }

    public void doOnError(String errorMsg) {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }

        if (!this.isHideToast()) {
            ToastUtils.showToast(errorMsg);
        }

        this.onError(errorMsg);
    }

    public void doOnNext(T t) {
        this.onSuccess(t);
    }

    public void doOnCompleted() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }

    }
}
