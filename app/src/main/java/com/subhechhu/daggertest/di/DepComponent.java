package com.subhechhu.daggertest.di;

import com.subhechhu.daggertest.MainActivityVM;
import com.subhechhu.daggertest.school.School;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DepModule.class})
public interface DepComponent {

    School provideSchool();

    void inject(MainActivityVM mainActivityVM);

}
