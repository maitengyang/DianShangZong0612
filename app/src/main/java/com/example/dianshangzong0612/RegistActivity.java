package com.example.dianshangzong0612;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dianshangzong0612.base.MainBase;
import com.example.dianshangzong0612.contract.Contract;
import com.example.dianshangzong0612.entry.LoginEntry;
import com.example.dianshangzong0612.entry.RegistEntry;
import com.example.dianshangzong0612.mvp.Presenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends MainBase  implements Contract.ConView {

private Contract.ConPresenter conPresenter;
    @BindView(R.id.regist_phone)
    EditText registPhone;
    @BindView(R.id.regist_pwd)
    EditText registPwd;
    @BindView(R.id.login_see)
    CheckBox loginSee;
    @BindView(R.id.regist_login)
    TextView registLogin;
    @BindView(R.id.regist_regist)
    Button registRegist;
    private String phone;
    private String pwd;
    private HashMap<String, String> registmap;
    private String regist_phone_pan;


    @Override
    protected int initlayout() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initview() {
        conPresenter=new Presenter();
        conPresenter.onAttch(this);
    }

    @Override
    protected void initdata() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_see, R.id.regist_login, R.id.regist_regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_see:
                loginSee.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                //默认不选中
                loginSee.setChecked(false);
                loginSee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (loginSee.isChecked()){   //如果选中，显示密码
                            registPhone.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        }else {     //否则隐藏
                            registPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                    }
                });
                break;
            case R.id.regist_login:
               Intent intent = new Intent(RegistActivity.this,LoginActivity.class);
                startActivity(intent);
                System.gc();
                finish();
                break;
            case R.id.regist_regist:
                phone = registPhone.getText().toString();
                pwd = registPwd.getText().toString();
                if (phone.isEmpty()|pwd.isEmpty()){
                    Toast.makeText(this, "账号或者密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else if (phone!=null&&pwd!=null){

//                if(phone.isEmpty()||pwd.isEmpty()){
//                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                    registmap = new HashMap<>();
                    registmap.put("phone",phone);
                    registmap.put("pwd",pwd);
                    conPresenter.UserRegistPresenter(registmap);
                }

                break;
        }
    }

    @Override
    public void UserLogin(LoginEntry loginEntry) {

    }

    @Override
    public void UserRegist(RegistEntry registEntry) {
        regist_phone_pan = registEntry.getMessage();
        if (regist_phone_pan.equals("注册成功")){
            Toast.makeText(this, ""+regist_phone_pan, Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(RegistActivity.this, LoginActivity.class);
            startActivity(intent1);

            System.gc();
            finish();
        }else {
            Toast.makeText(this, ""+regist_phone_pan, Toast.LENGTH_SHORT).show();
        }
    }
}
