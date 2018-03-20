package com.example.jiali.myapplication;

import android.app.Activity;
import android.os.Bundle;

import com.example.jiali.myapplication.ui.BaseActivity;


/**
 * @author jiali
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
