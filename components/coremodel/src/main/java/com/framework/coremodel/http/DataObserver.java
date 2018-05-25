package com.framework.coremodel.http;

import android.app.Dialog;

import com.allen.library.base.BaseDataObserver;
import com.allen.library.bean.BaseData;
import com.allen.library.utils.ToastUtils;

import io.reactivex.disposables.Disposable;

public abstract class DataObserver<T> extends BaseDataObserver<T> {
    private Dialog mProgressDialog;

    public DataObserver() {
    }

    public DataObserver(Dialog progressDialog) {
        this.mProgressDialog = progressDialog;
    }

    protected abstract void onError(String var1);

    protected abstract void onSuccess(T var1);

    public abstract void doOnSubscribe(Disposable d);

    public void doOnError(String errorMsg) {
        this.dismissLoading();
        if(!this.isHideToast()) {
            ToastUtils.showToast(errorMsg);
        }

        this.onError(errorMsg);
    }

    public void doOnNext(BaseData<T> data) {
        this.onSuccess(data.getData());
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
