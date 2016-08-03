package com.jonah.data.service;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public class JonahFactory {

    private static final long HTTP_CONNECT_TIME = 10;
    private static final long HTTP_READ_TIME = 30;
    private static final long HTTP_WRITE_TIME = 10;

    private static Cache mCache = new Cache(DataLayer.mContext.getCacheDir(),10*1024*1024);

    public static <T> T createService(Class<T> aClass,String baseUrl){
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(mCache)
                .connectTimeout(HTTP_CONNECT_TIME, TimeUnit.SECONDS)
                .readTimeout(HTTP_READ_TIME, TimeUnit.SECONDS)
                .writeTimeout(HTTP_WRITE_TIME,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(aClass);
    }
}
