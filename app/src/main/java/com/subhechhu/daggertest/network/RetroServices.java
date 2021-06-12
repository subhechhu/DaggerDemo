package com.subhechhu.daggertest.network;

import com.subhechhu.daggertest.model.MainResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServices {
    @GET("repositories")
    Call<MainResponse> makeApiCall(@Query("q") String q);
}
