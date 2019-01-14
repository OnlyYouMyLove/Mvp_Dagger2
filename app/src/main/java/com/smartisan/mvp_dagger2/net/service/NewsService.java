package com.smartisan.mvp_dagger2.net.service;

import com.smartisan.mvp_dagger2.entity.NewsInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET("toutiao/index")
    Observable<NewsInfo> getNewsInfo(@Query("type") String type, @Query("key")String key);
}
