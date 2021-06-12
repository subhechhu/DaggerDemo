package com.subhechhu.daggertest;

import android.app.Application;

import com.subhechhu.daggertest.di.DaggerDepComponent;
import com.subhechhu.daggertest.di.DepComponent;
import com.subhechhu.daggertest.di.DepModule;

public class MyApp extends Application {
    private DepComponent depComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        depComponent = DaggerDepComponent.builder().depModule(new DepModule()).build();
    }

    public DepComponent getDepComponent() {
        return depComponent;
    }
}
