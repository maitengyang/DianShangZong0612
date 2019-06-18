package com.example.dianshangzong0612.net;

import com.example.dianshangzong0612.entry.LoginEntry;
import com.example.dianshangzong0612.entry.RegistEntry;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/13
 *@Time:20:03
 *@Description:作用:
 * */public interface NetCallBack {
     void onLoginSuccess(LoginEntry loginEntry);
     void onRegist(RegistEntry registEntry);
     void onFail(String s);
}
