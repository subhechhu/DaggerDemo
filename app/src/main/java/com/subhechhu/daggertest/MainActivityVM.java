package com.subhechhu.daggertest;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.subhechhu.daggertest.model.MainResponse;
import com.subhechhu.daggertest.network.RetroServices;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityVM extends AndroidViewModel {

    @Inject
    RetroServices retroServices;

    MutableLiveData<MainResponse> mutableLiveData;

    public MainActivityVM(@NonNull Application application) {
        super(application);
        ((MyApp) application).getDepComponent().inject(this);
        mutableLiveData = new MutableLiveData<>();
    }

    public void makeApiCall() {
        Call<MainResponse> call = retroServices.makeApiCall("bangalore");
        call.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response == null) {
                    mutableLiveData.setValue(null);
                } else {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable throwable) {
                mutableLiveData.setValue(null);
            }
        });
    }

    public MutableLiveData<MainResponse> getData() {
        return mutableLiveData;
    }
}
