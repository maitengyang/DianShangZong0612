package com.example.dianshangzong0612.mvp;

import com.example.dianshangzong0612.contract.Contract;
import com.example.dianshangzong0612.entry.LoginEntry;
import com.example.dianshangzong0612.entry.RegistEntry;
import com.example.dianshangzong0612.net.NetCallBack;

import java.util.HashMap;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/17
 *@Time:15:24
 *@Description:作用:
 * */public class Presenter implements Contract.ConPresenter {
     private Contract.ConModel conModel;
     private Contract.ConView conView;
    @Override
    public void onAttch(Contract.ConView conView) {
        conModel=new Model();
        this.conView=conView;
    }

    @Override
    public void onDestory() {
        if (conView!=null){
            conView=null;
        }
        if (conModel!=null){
            conModel=null;
        }
        System.gc();
    }

    @Override
    public void UserLoginPresenter(HashMap<String, String> prams) {
        conModel.UserLoginModel(prams, new NetCallBack() {
            @Override
            public void onLoginSuccess(LoginEntry loginEntry) {
                conView.UserLogin(loginEntry);
            }

            @Override
            public void onRegist(RegistEntry registEntry) {

            }

            @Override
            public void onFail(String s) {

            }
        });
    }

    @Override
    public void UserRegistPresenter(HashMap<String, String> registmap) {
        conModel.UserRegistModel(registmap, new NetCallBack() {
            @Override
            public void onLoginSuccess(LoginEntry loginEntry) {

            }

            @Override
            public void onRegist(RegistEntry registEntry) {
                conView.UserRegist(registEntry);
            }

            @Override
            public void onFail(String s) {

            }
        });
    }


}
