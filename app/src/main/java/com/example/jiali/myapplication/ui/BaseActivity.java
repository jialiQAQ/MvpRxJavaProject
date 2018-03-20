package com.example.jiali.myapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.jiali.myapplication.MyApplication;

import butterknife.ButterKnife;

/**
 * @author jiali
 * @date 2018/3/20
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        MyApplication.getInstance().addActivity(this);
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getInstance().getRefWatcher().watch(this);
        MyApplication.getInstance().removeActivity(this);
    }
}
