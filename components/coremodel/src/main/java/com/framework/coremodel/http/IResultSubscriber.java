package com.framework.coremodel.http;

import io.reactivex.disposables.Disposable;

/**
 * Created by dyping on 2018/3/29.
 */

public interface IResultSubscriber<T> {

    void doOnSubscribe(Disposable var1);

    void doOnError(String var1);

    void doOnNext(HttpResult<T> var1);

    void doOnCompleted();


}
