package com.example.jiali.myapplication;

import android.app.Activity;
import android.app.Application;

import com.example.jiali.myapplication.module.BaseActivity;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiali on 2018/3/20.
 */

public class MyApplication extends Application {
    private RefWatcher refWatcher;

    private List<BaseActivity> activityList = new ArrayList<>();

    private static class MyApplicationHolder {
        private static MyApplication INSTANCE = new MyApplication();
    }

    private MyApplication() {

    }

    public static MyApplication getInstance() {
        return MyApplicationHolder.INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);
    }

    public void addActivity(BaseActivity activity) {
        activityList.add(activity);
    }

    public void removeActivity(BaseActivity activity) {
        activityList.remove(activity);
    }

    public void finish() {
        if (activityList != null && !activityList.isEmpty()) {
            for (Activity activity : activityList) {
                activity.finish();
            }
        }
        System.exit(0);
    }

    public RefWatcher getRefWatcher() {
        return refWatcher;
    }

    public void setRefWatcher(RefWatcher refWatcher) {
        this.refWatcher = refWatcher;
    }
}
