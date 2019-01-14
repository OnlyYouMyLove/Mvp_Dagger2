package com.smartisan.mvp_dagger2.component;

import com.smartisan.mvp_dagger2.module.NetTaskModule;
import com.smartisan.mvp_dagger2.mvp.model.interfaces.NetTask;
import com.smartisan.mvp_dagger2.net.manager.RetrofitManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetTaskModule.class)
public interface NetTaskComponent {
    NetTask getNetTask();
    RetrofitManager getRetrofitManager();
}
