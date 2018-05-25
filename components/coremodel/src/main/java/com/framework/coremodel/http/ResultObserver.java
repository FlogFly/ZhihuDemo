package com.framework.coremodel.http;

import android.app.Dialog;

import com.allen.library.utils.ToastUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by dyping on 2018/3/29.
 */

public abstract class ResultObserver<T> extends ResultBaseObserver<T> {

    private Dialog mProgressDialog;

    public ResultObserver() {
    }

    public ResultObserver(Dialog progressDialog) {
        this.mProgressDialog = progressDialog;
    }

    protected abstract void onError(String var1);

    protected abstract void onSuccess(T var1);

    public void doOnSubscribe(Disposable d) {

        if (mProgressDialog != null) {
            mProgressDialog.show();
        }
    }

    public void doOnError(String errorMsg) {
        this.dismissLoading();

        if (!this.isHideToast()) {
            ToastUtils.showToast(errorMsg);
        }

        this.onError(errorMsg);
    }

    public void doOnNext(HttpResult<T> data) {
        this.onSuccess(data.getObj());
    }

    public void doOnCompleted() {
        this.dismissLoading();
    }

    private void dismissLoading() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
    }


}
