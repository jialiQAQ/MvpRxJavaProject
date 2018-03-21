package com.example.jiali.myapplication.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jiali.myapplication.MyApplication;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author jiali
 * @date 2018/3/20
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected List<BasePresenter> presenterList = new ArrayList<>();

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        MyApplication.getInstance().addActivity(this);
        unbinder = ButterKnife.bind(this);
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (!presenterList.isEmpty()) {
            for (BasePresenter presenter : presenterList) {
                presenter.unregister();
            }
        }
        MyApplication.getInstance().getRefWatcher().watch(this);
        MyApplication.getInstance().removeActivity(this);
    }
}
