package com.example.dianshangzong0612.mvp;

import com.example.dianshangzong0612.api.ApiService;
import com.example.dianshangzong0612.contract.Contract;
import com.example.dianshangzong0612.entry.LoginEntry;
import com.example.dianshangzong0612.entry.RegistEntry;
import com.example.dianshangzong0612.net.NetCallBack;
import com.example.dianshangzong0612.net.RetrofitHttpUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/17
 *@Time:15:22
 *@Description:作用:
 * */public class Model implements Contract.ConModel {
    @Override
    public void UserLoginModel(HashMap<String, String> prams, final NetCallBack netCallBack) {
        RetrofitHttpUtil.getInstance().CreateService(ApiService.class)
                .UserLogin(prams).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<LoginEntry>() {
            @Override
            public void accept(LoginEntry loginEntry) throws Exception {
                netCallBack.onLoginSuccess(loginEntry);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                netCallBack.onFail("网络出了点小问题");
            }
        });
    }

    @Override
    public void UserRegistModel(HashMap<String, String> registmap, final NetCallBack netCallBack) {
        RetrofitHttpUtil.getInstance().CreateService(ApiService.class)
                .UserRegist(registmap).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<RegistEntry>() {
            @Override
            public void accept(RegistEntry registEntry) throws Exception {
                netCallBack.onRegist(registEntry);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                netCallBack.onFail("网络有问题！！");
            }
        });
    }
}
