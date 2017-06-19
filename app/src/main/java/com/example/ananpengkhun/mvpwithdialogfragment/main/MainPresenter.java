package com.example.ananpengkhun.mvpwithdialogfragment.main;

import android.util.Log;

import com.example.ananpengkhun.mvpwithdialogfragment.DataDao;
import com.example.ananpengkhun.mvpwithdialogfragment.httpmanager.TestHttpManager;
import com.example.ananpengkhun.mvpwithdialogfragment.preferrence.MyPreferrence;

import java.util.List;

import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ananpengkhun on 6/16/17.
 */

public class MainPresenter implements MainContractor.MainPresenter {
    private MainContractor.View view;
    private MainActivity mainActivity;
    private List<DataDao> daoList;

    public MainPresenter(MainContractor.View view, MainActivity mainActivity) {
        this.view = view;
        this.mainActivity = mainActivity;
        view.setPresenter(this);
    }

    @Override
    public int userdata() {
        return 10;
    }

    @Override
    public void callService() {
        Observable.fromCallable(new Callable<List<DataDao>>() {
            @Override
            public List<DataDao> call() throws Exception {
                return CallData();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<DataDao>>() {
                    @Override
                    public void onCompleted() {
                        view.getData(daoList);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<DataDao> dataDaos) {
                        Log.d("data", "onResponse: " + daoList.size());
                    }
                });
    }

    @Override
    public void putUsername(String name) {
        MyPreferrence.getInstance(mainActivity).updateUsername(name);
    }

    @Override
    public void getUserData() {
        view.getUsername(MyPreferrence.getInstance(mainActivity).getUsername());
    }

    public List<DataDao> CallData() {
        TestHttpManager.getInstance().getTestService().getDataInfo().enqueue(new Callback<List<DataDao>>() {
            @Override
            public void onResponse(Call<List<DataDao>> call, Response<List<DataDao>> response) {
                daoList = response.body();
            }

            @Override
            public void onFailure(Call<List<DataDao>> call, Throwable t) {
                Log.d("data", "onResponse: " + t.getMessage());
                daoList = null;
            }
        });
        return daoList;
    }
}
