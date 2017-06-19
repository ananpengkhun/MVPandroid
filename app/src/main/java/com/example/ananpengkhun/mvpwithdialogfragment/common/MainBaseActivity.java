package com.example.ananpengkhun.mvpwithdialogfragment.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ananpengkhun.mvpwithdialogfragment.R;
import com.example.ananpengkhun.mvpwithdialogfragment.dialog.MainBaseFragment;

public abstract class MainBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showDialogSuccess(String title, String description, MainBaseFragment.MainBaseOnClicklistener mainBaseOnClicklistener){
        MainBaseFragment mainBaseFragment = MainBaseFragment.createSuccessDialog(title,description,mainBaseOnClicklistener);
        mainBaseFragment.show(getSupportFragmentManager(),"SuccessDialog");
    }

    public void showDialogError(String title, String description, MainBaseFragment.MainBaseOnClicklistener mainBaseOnClicklistener){
        MainBaseFragment mainBaseFragment = MainBaseFragment.createErrorDialog(title,description,mainBaseOnClicklistener);
        mainBaseFragment.show(getSupportFragmentManager(),"ErrorDialog");
    }
}
