package com.demo.donation.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.framework.donation.chintframework.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    Disposable a, b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Button btn = findViewById(R.id.app_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouterUtil.normalNavigation("/splashmodule/main");
            }
        });*/


        final Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.v("dyp", "var1：" + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        observable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.v("dyp", "var2：" + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });







     /*   observable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                a = d;
            }

            @Override
            public void onNext(Long var1) {
                Log.v("dyp", "var1:" + var1);
                if (var1 == 5) {
                    observable.subscribe(new Observer<Long>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            b = d;
                        }

                        @Override
                        public void onNext(Long aLong) {
                            Log.v("dyp", "var2：" + aLong);
                            if (aLong == 10) {
                                b.dispose();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
                }

                if (var1 == 15) {
                    a.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

*/
       // ((ConnectableObservable<Long>) observable).connect();
    }


}
