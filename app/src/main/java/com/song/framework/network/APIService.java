package com.song.framework.network;

import com.song.framework.model.DetailModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by songyawei on 2017/4/13.
 */
public interface APIService {
    @GET("chengyu")
    Observable<DetailModel> query(@Query("chengyu") String chengyu);

    @GET("chengyu")
    Observable<List<DetailModel>> queryArray(@Query("chengyu") String chengyu);

    @GET("chengyu")
    Observable<String> queryString(@Query("chengyu") String chengyu);
}
