package com.framework.common.commonrx;


import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by willy on 17/1/5.
 */

public class RxBus {

    public static volatile RxBus instance;
    public final Subject mSubject;
    private ConcurrentHashMap<String, CompositeDisposable> disposableHashMap;


    public RxBus() {
        // toSerialized method made bus thread safe
        mSubject = PublishSubject.create().toSerialized();
    }

    public static RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }

        return instance;
    }


    public <T> Disposable doSubscribe(Class<T> type, Consumer<T> next, Consumer<Throwable> error) {
        return getObservable(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(next, error);
    }

    public <T> Flowable<T> getObservable(Class<T> type) {
        return mSubject.toFlowable(BackpressureStrategy.BUFFER)
                .ofType(type);
    }


    public void post(Object o) {
        mSubject.onNext(o);
    }

    public void post(int code, Object o) {
        this.post(new RxBusMessage(code, o));
    }


    // 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return mSubject.ofType(eventType);
    }


    public <T> Observable<T> toObservable(final int code, final Class<T> eventType) {

        return mSubject.ofType(RxBusMessage.class).filter(new Predicate<RxBusMessage>() {

            @Override
            public boolean test(RxBusMessage rxBusMessage) throws Exception {
                return rxBusMessage.getCode() == code && eventType.isInstance(rxBusMessage.getObject());
            }
        }).map(new Function<RxBusMessage, Object>() {
            @Override
            public Object apply(RxBusMessage rxBusMessage) throws Exception {
                return rxBusMessage.getObject();
            }
        });
    }


    public void addSubscription(Object o, Disposable disposable) {
        if (disposableHashMap == null) {
            disposableHashMap = new ConcurrentHashMap<>();
        }
        String key = o.getClass().getName();
        if (disposableHashMap.get(key) != null) {
            disposableHashMap.get(key).add(disposable);
        } else {
//            代表一组订阅,订阅 unsubscribed在一起
            CompositeDisposable compositeSubscription = new CompositeDisposable();
            compositeSubscription.add(disposable);
            disposableHashMap.put(key, compositeSubscription);
        }
    }

    /**
     * 取消订阅
     *
     * @param o
     */
    public void unSubscribe(Object o) {
        if (disposableHashMap == null) {
            return;
        }
        String key = o.getClass().getName();
        if (!disposableHashMap.containsKey(key)) {
            return;
        }
        if (disposableHashMap.get(key) != null) {
            disposableHashMap.get(key).dispose();
        }
        disposableHashMap.remove(key);
    }

}
