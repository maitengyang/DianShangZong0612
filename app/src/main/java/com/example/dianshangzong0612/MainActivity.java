package com.example.dianshangzong0612;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dianshangzong0612.fragment.CartFragment;
import com.example.dianshangzong0612.fragment.DingDan;
import com.example.dianshangzong0612.fragment.FindFragment;
import com.example.dianshangzong0612.fragment.HomeFragment;
import com.example.dianshangzong0612.fragment.MyFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_view)
    ViewPager mainView;
    @BindView(R.id.ra_home)
    RadioButton raHome;
    @BindView(R.id.ra_find)
    RadioButton raFind;
    @BindView(R.id.ra_cart)
    RadioButton raCart;
    @BindView(R.id.ra_ding)
    RadioButton raDing;
    @BindView(R.id.ra_my)
    RadioButton raMy;
    @BindView(R.id.main_radio_but)
    RadioGroup mainRadioBut;
    private ArrayList<Fragment> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list.add(new HomeFragment());
        list.add(new FindFragment());
        list.add(new CartFragment());
        list.add(new DingDan());
        list.add(new MyFragment());
        mainView.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mainView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mainRadioBut.check(R.id.ra_home);
                        break;
                    case 1:
                        mainRadioBut.check(R.id.ra_find);
                        break;
                        case 2:
                        mainRadioBut.check(R.id.ra_cart);
                        break;
                    case 3:
                        mainRadioBut.check(R.id.ra_ding);
                        break;
                    case 4:
                        mainRadioBut.check(R.id.ra_my);
                        break;


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mainRadioBut.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.ra_home:
                        mainView.setCurrentItem(0);
                        break;
                    case R.id.ra_find:
                        mainView.setCurrentItem(1);
                        break;
                    case R.id.ra_cart:
                        mainView.setCurrentItem(2);
                        break;
                    case R.id.ra_ding:
                        mainView.setCurrentItem(3);
                        break;
                    case R.id.ra_my:
                        mainView.setCurrentItem(4);
                        break;
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }


}
