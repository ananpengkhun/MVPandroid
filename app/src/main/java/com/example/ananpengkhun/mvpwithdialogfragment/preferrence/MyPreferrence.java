package com.example.ananpengkhun.mvpwithdialogfragment.preferrence;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class MyPreferrence {
    private static MyPreferrence ourInstance;
    private static Context context;
    private static final String MY_PREF = "MYAPP";

    public static MyPreferrence getInstance(Context mContext) {
        if(ourInstance == null){
            ourInstance = new MyPreferrence();
        }
        context = mContext;
        return ourInstance;
    }

    private MyPreferrence() {
    }

    public String getUsername(){
        return getSharedPreferences(context).getString("Username","null");
    }

    public void updateUsername(String username){
        getSharedPreferences(context).edit().putString("Username",username).apply();
    }

    public static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
    }
}
