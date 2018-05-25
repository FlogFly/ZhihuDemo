package com.framework.common.commonrx;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by dyping on 2018/3/29.
 *
 * 管理了RxBus 和 Observable的订阅与解除
 */

public class RxManager {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void add(Disposable d) {
        compositeDisposable.add(d);
    }

    public void clear() {
        compositeDisposable.dispose();
    }
}
