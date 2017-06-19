package com.example.ananpengkhun.mvpwithdialogfragment;

import android.content.Context;

/**
 * Created by ananpengkhun on 6/16/17.
 */

public class Contextor {
    private static Contextor ourInstance = new Contextor();
    private Context context;
    public static Contextor getInstance() {
        if(ourInstance == null){
            ourInstance = new Contextor();
        }
        return ourInstance;
    }

    private Contextor() {
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
