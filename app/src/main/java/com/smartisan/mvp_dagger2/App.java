package com.smartisan.mvp_dagger2;

import android.app.Application;
import android.content.Context;

import com.smartisan.mvp_dagger2.component.DaggerNetTaskComponent;
import com.smartisan.mvp_dagger2.component.NetTaskComponent;

public class App extends Application {

    private NetTaskComponent mNetTaskComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetTaskComponent = DaggerNetTaskComponent.builder().build();
    }

    public static App get(Context context){
        return (App)context.getApplicationContext();
    }

    public NetTaskComponent getNetTaskComponent() {
        return mNetTaskComponent;
    }
}

