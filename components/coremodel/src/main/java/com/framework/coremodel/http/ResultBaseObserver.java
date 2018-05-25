package com.framework.coremodel.http;

import com.allen.library.exception.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dyping on 2018/3/29.
 */

public abstract class ResultBaseObserver<T> implements Observer<HttpResult<T>>, IResultSubscriber<T> {

    public ResultBaseObserver() {
    }

    protected boolean isHideToast() {
        return false;
    }

    public void onSubscribe(Disposable d) {
        this.doOnSubscribe(d);
    }

    public void onNext(HttpResult<T> baseData) {
        this.doOnNext(baseData);
    }

    public void onError(Throwable e) {
        String error = ApiException.handleException(e).getMessage();
        this.setError(error);
    }

    public void onComplete() {
        this.doOnCompleted();
    }

    private void setError(String errorMsg) {
        this.doOnError(errorMsg);
    }

}
