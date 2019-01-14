package com.smartisan.mvp_dagger2.component;

import com.smartisan.mvp_dagger2.module.NetTaskModule;
import com.smartisan.mvp_dagger2.mvp.model.interfaces.NetTask;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetTaskModule.class)
public interface NetTaskComponent {
    NetTask getNetTask();
}
