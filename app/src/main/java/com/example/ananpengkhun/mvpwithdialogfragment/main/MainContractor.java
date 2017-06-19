package com.example.ananpengkhun.mvpwithdialogfragment.main;

import com.example.ananpengkhun.mvpwithdialogfragment.BasePresent;
import com.example.ananpengkhun.mvpwithdialogfragment.BaseView;
import com.example.ananpengkhun.mvpwithdialogfragment.DataDao;

import java.util.List;

/**
 * Created by ananpengkhun on 6/16/17.
 */

public class MainContractor {
    public interface MainPresenter extends BasePresent{
        int userdata();
        void callService();
        void putUsername(String name);
        void getUserData();
    }

    public  interface View extends BaseView<MainContractor.MainPresenter>{
        void getData(List<DataDao> dataDao);
        void getUsername(String username);
    }
}
