package com.example.dianshangzong0612.contract;

import com.example.dianshangzong0612.entry.LoginEntry;
import com.example.dianshangzong0612.entry.RegistEntry;
import com.example.dianshangzong0612.net.NetCallBack;

import java.util.HashMap;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/17
 *@Time:15:19
 *@Description:作用:
 * */public interface Contract {
     public interface ConView{
         void UserLogin(LoginEntry loginEntry);
         void UserRegist(RegistEntry registEntry);
     }
    public interface ConModel{
         void UserLoginModel(HashMap<String,String> prams, NetCallBack netCallBack);
        void UserRegistModel(HashMap<String,String> registmap, NetCallBack netCallBack);
    }
    public interface ConPresenter{
         void onAttch(ConView conView);
         void onDestory();
         void UserLoginPresenter(HashMap<String,String> prams);
        void UserRegistPresenter(HashMap<String,String> registmap);
    }

}
