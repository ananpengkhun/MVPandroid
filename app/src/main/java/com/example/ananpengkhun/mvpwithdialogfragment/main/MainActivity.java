package com.example.ananpengkhun.mvpwithdialogfragment.main;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.ananpengkhun.mvpwithdialogfragment.DataDao;
import com.example.ananpengkhun.mvpwithdialogfragment.R;
import com.example.ananpengkhun.mvpwithdialogfragment.common.MainBaseActivity;
import com.example.ananpengkhun.mvpwithdialogfragment.dialog.MainBaseFragment;
import com.example.ananpengkhun.mvpwithdialogfragment.httpmanager.TestHttpManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.Hello1Fragment;
import layout.Hello2Fragment;

public class MainActivity extends MainBaseActivity implements MainContractor.View{

    @BindView(R.id.btn_hello1) Button btnHello1;
    @BindView(R.id.btn_hello2) Button btnHello2;
    @BindView(R.id.btn_show_data) Button btnShowData;
    @BindView(R.id.rc_data) RecyclerView rcData;
    //@BindView(R.id.container) FrameLayout container;
    private MainContractor.MainPresenter presenter;
    private DataAdapter dataAdapter;
    private List<DataDao> dataDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this,MainActivity.this);
        initMenu();

    }

    private void initMenu() {
        Log.d("sss", "initMenu: "+presenter.userdata());
        btnHello1.setOnClickListener(onChooseClicklistener);
        btnHello2.setOnClickListener(onChooseClicklistener);
        btnShowData.setOnClickListener(onChooseClicklistener);
    }

    private View.OnClickListener onChooseClicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.btn_hello1) {
                showDialogSuccess("success", "you can access", new MainBaseFragment.MainBaseOnClicklistener() {
                    @Override
                    public boolean onCLick(MainBaseFragment mainBaseFragment, View view) {
                        mainBaseFragment.dismiss();
                        presenter.putUsername("anan pengkhun");
                        return false;
                    }
                });
                //homeHello1();
            } else if (id == R.id.btn_hello2) {
                showDialogError("Error", "Can't access anything", new MainBaseFragment.MainBaseOnClicklistener() {
                    @Override
                    public boolean onCLick(MainBaseFragment mainBaseFragment, View view) {
                        mainBaseFragment.dismiss();
                        presenter.getUserData();
                        return false;
                    }
                });
            }else if(id == R.id.btn_show_data){
                presenter.callService();
            }
        }
    };

    private void homeHello1() {
//        getSupportFragmentManager().beginTransaction()
//                .replace(container.getId(), Hello1Fragment.newInstant(),"hello1")
//                .addToBackStack(null)
//                .commit();
    }

    private void homeHello2() {
//        getSupportFragmentManager().beginTransaction()
//                .replace(container.getId(), Hello2Fragment.newInstant(),"hello2")
//                .addToBackStack(null)
//                .commit();
    }

    @Override
    public void setPresenter(MainContractor.MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        rcData.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        dataAdapter = new DataAdapter();
        dataAdapter.setData(dataDao);
        rcData.setAdapter(dataAdapter);
    }

    @Override
    public void getData(List<DataDao> dataDao) {
        this.dataDao = dataDao;
    }

    @Override
    public void getUsername(String username) {
        Log.d("username", "getUsername: "+username);
    }
}
