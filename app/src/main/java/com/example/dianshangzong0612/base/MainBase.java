package com.example.dianshangzong0612.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/12
 *@Time:21:07
 *@Description:作用:
 * */public  abstract class MainBase extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayout());
        initview();
        initdata();

    }

    protected abstract int initlayout();

    protected abstract void initview();

    protected abstract void initdata();
}
