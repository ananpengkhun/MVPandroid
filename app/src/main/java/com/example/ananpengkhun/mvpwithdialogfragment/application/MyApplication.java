package com.example.ananpengkhun.mvpwithdialogfragment.application;

import android.app.Application;
import android.content.Context;

import com.example.ananpengkhun.mvpwithdialogfragment.Contextor;

/**
 * Created by ananpengkhun on 6/16/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().setContext(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
