package com.smartisan.mvp_dagger2.module;

import com.smartisan.mvp_dagger2.mvp.contract.NewsInfoContract;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsInfoModule {

    private NewsInfoContract.View mView;

    public NewsInfoModule(NewsInfoContract.View view) {
        mView = view;
    }

    @Provides
    public NewsInfoContract.View provideNewsInfoContractView() {
        return mView;
    }

}
