package com.example.dianshangzong0612.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/18
 *@Time:15:50
 *@Description:作用:
 * */public  abstract class FragBase extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(initlayout(), container, false);
        return inflate;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
        initdata();
    }
    protected abstract int initlayout();
    protected abstract void initview();

    protected abstract void initdata();
}
