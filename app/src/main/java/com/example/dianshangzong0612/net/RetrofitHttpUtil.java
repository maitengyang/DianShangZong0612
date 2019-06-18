package com.example.dianshangzong0612.net;

import com.example.dianshangzong0612.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/13
 *@Time:20:04
 *@Description:作用:
 * */public class RetrofitHttpUtil {
private static RetrofitHttpUtil retrofitHttpUtil;
private Retrofit retrofit;


    public static RetrofitHttpUtil getInstance(){
        if (retrofitHttpUtil==null){
            synchronized (RetrofitHttpUtil.class){
                if (retrofitHttpUtil==null){
                    retrofitHttpUtil=new RetrofitHttpUtil();
                }
            }
        }

        return retrofitHttpUtil;
    }
    private RetrofitHttpUtil() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }
    public <T> T CreateService(Class<T> tClass){
       return retrofit.create(tClass);
    }
}

