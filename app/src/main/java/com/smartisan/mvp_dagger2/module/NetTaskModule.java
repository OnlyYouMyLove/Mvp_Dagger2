package com.smartisan.mvp_dagger2.module;

import com.smartisan.mvp_dagger2.mvp.model.imp.NewsInfoTask;
import com.smartisan.mvp_dagger2.mvp.model.interfaces.NetTask;
import com.smartisan.mvp_dagger2.net.manager.RetrofitManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetTaskModule {
    @Singleton
    @Provides
    public NetTask provideNewsInfoTask(){
        return new NewsInfoTask();
    }

    @Singleton
    @Provides
    public RetrofitManager provideRetrofitManager(){
        return new RetrofitManager();
    }
}
