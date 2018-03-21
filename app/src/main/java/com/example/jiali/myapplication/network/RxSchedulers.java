package com.example.jiali.myapplication.network;


import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * @author jiali
 * @date 2017/7/13
 */
public class RxSchedulers {

    public static <T> ObservableTransformer<T, T> compose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
