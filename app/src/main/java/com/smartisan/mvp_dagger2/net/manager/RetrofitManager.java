package com.smartisan.mvp_dagger2.net.manager;

import com.smartisan.mvp_dagger2.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static Retrofit sRetrofit = null;
    private static String sUrl = "";
    private static final int TIMEOUT = 20;

    private RetrofitManager() {
    }

    public static RetrofitManager getInstance() {
        return RetrofitManagerHolder.sInstance;
    }

    private static class RetrofitManagerHolder {
        private static final RetrofitManager sInstance = new RetrofitManager();
    }

    public Retrofit getRetrofit(String baseUrl) {
        sUrl = baseUrl;
        if (sRetrofit == null) {
            return create();
        } else {
            return sRetrofit;
        }
    }

    private Retrofit create() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor)
                .connectTimeout(TIMEOUT,TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).build();

        sRetrofit = new Retrofit.Builder()
                .baseUrl(sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return sRetrofit;
    }
}