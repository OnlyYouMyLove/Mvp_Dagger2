package com.smartisan.mvp_dagger2;

import android.app.Application;

import com.smartisan.mvp_dagger2.component.DaggerNetTaskComponent;
import com.smartisan.mvp_dagger2.component.NetTaskComponent;

public class App extends Application {

    private static NetTaskComponent mNetTaskComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetTaskComponent = DaggerNetTaskComponent.builder().build();
    }

    public static NetTaskComponent getNetTaskComponent() {
        return mNetTaskComponent;
    }
}

