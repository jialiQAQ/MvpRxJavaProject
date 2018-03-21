package com.example.jiali.myapplication.module;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author jiali
 */
public abstract class BasePresenter {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private WeakReference<BaseView> weakReference;

    private BaseModel model;

    protected BasePresenter(BaseView baseView) {
        weakReference = new WeakReference<>(baseView);
        baseView.setPresenter(this);
        this.model = createModel();
    }

    protected abstract BaseModel createModel();

    protected void register(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    void unregister() {
        compositeDisposable.clear();
        if (weakReference.get() != null) {
            weakReference.clear();
        }
        if (model != null) {
            model.clear();
        }
    }

}
