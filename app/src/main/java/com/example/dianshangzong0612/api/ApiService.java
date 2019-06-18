package com.example.dianshangzong0612.api;

import com.example.dianshangzong0612.entry.LoginEntry;
import com.example.dianshangzong0612.entry.RegistEntry;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/17
 *@Time:15:07
 *@Description:作用:
 * */public interface ApiService {
    @FormUrlEncoded
     @POST(Api.USER_LOGIN)
     Observable<LoginEntry> UserLogin(@FieldMap HashMap<String,String> prams);
     @POST(Api.USER_REGISTER)
     @FormUrlEncoded
    Observable<RegistEntry> UserRegist(@FieldMap HashMap<String,String> registmap);
}
