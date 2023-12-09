package com.example.projetmob.service;


import com.example.projetmob.model.Emissions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface listRepoServiceAPI {
    @GET("search/shows?q=golden%20girls")
   // Call<List<Emissions>> getEmissions();
    Call<List<Emissions>> searchShows();
}
