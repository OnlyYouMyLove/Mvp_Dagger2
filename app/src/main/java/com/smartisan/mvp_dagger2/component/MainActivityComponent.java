package com.smartisan.mvp_dagger2.component;

import com.smartisan.mvp_dagger2.scope.ActivityScoped;
import com.smartisan.mvp_dagger2.module.NewsInfoModule;
import com.smartisan.mvp_dagger2.mvp.view.MainActivity;

import dagger.Component;

    @ActivityScoped
    @Component(modules = NewsInfoModule.class,dependencies =NetTaskComponent.class)
    public interface MainActivityComponent {
        void inject(MainActivity mainActivity);
    }
