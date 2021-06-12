package com.subhechhu.daggertest.di;

import com.subhechhu.daggertest.network.RetroServices;
import com.subhechhu.daggertest.school.Student;
import com.subhechhu.daggertest.school.Teacher;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DepModule {
    private final String BASE_URL = "https://api.github.com/search/";

    @Singleton
    @Provides
    public Student studentProvider() {
        return new Student();
    }

    @Singleton
    @Provides
    public Teacher teacherProvider() {
        return new Teacher();
    }


    @Singleton
    @Provides
    public Retrofit retrofitProvider() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public RetroServices retroServicesProvider(Retrofit retrofit) {
        return retrofit.create(RetroServices.class);
    }
}
