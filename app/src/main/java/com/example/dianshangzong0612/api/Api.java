package com.example.dianshangzong0612.api;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/13
 *@Time:10:40
 *@Description:作用:
 * */public interface Api {
    public static final String WAI_URL = "mobile.bwstudent.com";
    public static final String BASE_URL = "http://172.17.8.100/";
    public  static final String FIND_SHOW = "/small/commodity/v1/findCommodityByKeyword";
    //http://172.17.8.100/small/user/v1/register
    public  static final String USER_REGISTER = "/small/user/v1/register";
    public  static final String USER_LOGIN = "/small/user/v1/login";
    public  static final String USER_SHOW = "/small/commodity/v1/commodityList";

    //small/commodity/v1/bannerShow
    public  static final String BANNER_SHOW = "/small/commodity/v1/bannerShow";
}
