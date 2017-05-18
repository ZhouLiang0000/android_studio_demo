package com.asiainfo.android_studio_demo;

import android.app.Application;

import com.chenenyu.router.Router;

/**
 * Created by zhouliang on 2017/5/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Router.initialize(this, true);
    }
}
