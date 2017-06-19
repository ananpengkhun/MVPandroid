package com.example.ananpengkhun.mvpwithdialogfragment.httpmanager;

import com.example.ananpengkhun.mvpwithdialogfragment.httpmanager.api.TestService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ananpengkhun on 6/16/17.
 */

public class TestHttpManager {
    private static TestHttpManager ourInstance;
    private TestService testService;

    public static TestHttpManager getInstance() {
        if(ourInstance == null){
            ourInstance = new TestHttpManager();
        }
        return ourInstance;
    }

    private TestHttpManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://beta.json-generator.com/api/json/get/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        testService = retrofit.create(TestService.class);
    }

    public TestService getTestService() {
        return testService;
    }
}
