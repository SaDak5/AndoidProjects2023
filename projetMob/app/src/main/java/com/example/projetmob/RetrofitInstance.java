package com.example.projetmob;

import com.example.projetmob.service.listRepoServiceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static RetrofitInstance instance;
    public static listRepoServiceAPI apiInterface;

    RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.tvmaze.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(listRepoServiceAPI.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance == null){
            instance = new RetrofitInstance();
        }
        return instance ;
    }
}