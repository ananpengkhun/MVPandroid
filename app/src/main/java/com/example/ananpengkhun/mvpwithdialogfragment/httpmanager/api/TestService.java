package com.example.ananpengkhun.mvpwithdialogfragment.httpmanager.api;

import com.example.ananpengkhun.mvpwithdialogfragment.DataDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ananpengkhun on 6/16/17.
 */

public interface TestService {
    @GET("Vk2gVSuGX")
    Call<List<DataDao>> getDataInfo();
}
