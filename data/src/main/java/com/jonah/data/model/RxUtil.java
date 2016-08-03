package com.jonah.data.model;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public class RxUtil {
    public static <T> Observable.Transformer transform(){
        return new Observable.Transformer<T,T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .throttleFirst(2, TimeUnit.SECONDS)
                        .doOnError(new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                if (throwable!= null) {
                                    throwable.printStackTrace();
                                }
                            }
                        });
            }
        };
    }
}
