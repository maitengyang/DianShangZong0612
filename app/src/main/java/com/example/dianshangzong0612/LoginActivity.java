package com.example.dianshangzong0612;

import android.content.Intent;
import android.content.SharedPreferences;
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

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MainBase  implements Contract.ConView {

private Contract.ConPresenter conPresenter;
    @BindView(R.id.login_phone)
    EditText ed_Phone;
    @BindView(R.id.login_pwd)
    EditText ed_Pwd;
    @BindView(R.id.login_see)
    CheckBox che_see;
    @BindView(R.id.login_checkBox)
    CheckBox loginCheckBox;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.login_btn)
    Button loginBtn;
    private String sessionId;
    private String userId;
    private String login_pan="";
    private String my_phone;
    private String my_pwd;
    private String spuserphone;
    private String spuserpwd;
    private SharedPreferences sp;


    @Override
    protected int initlayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initview() {
        conPresenter=new Presenter();
        conPresenter.onAttch(this);

    }

    @Override
    protected void initdata() {
//        //创建SharedPreferences对象
//        sp = getSharedPreferences("info", MODE_PRIVATE);
//        if (ed_Phone!=null||ed_Pwd!=null){
//            readAccount();
//        }else {
//            Toast.makeText(this, "空的空的", Toast.LENGTH_SHORT).show();
//        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_phone, R.id.login_pwd, R.id.login_see, R.id.login_checkBox, R.id.login_register, R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_phone:
                break;
            case R.id.login_pwd:
                break;
            case R.id.login_see:
                che_see.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                //默认不选中
                che_see.setChecked(false);
                che_see.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (che_see.isChecked()){   //如果选中，显示密码
                            ed_Pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        }else {     //否则隐藏
                            ed_Pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                    }
                });
                break;
            case R.id.login_checkBox:
                if(loginCheckBox.isChecked()) {

//                    //创建sharedPreference对象，info表示文件名，MODE_PRIVATE表示访问权限为私有的
////                    SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
//
//                    //获得sp的编辑器
//                    SharedPreferences.Editor ed = sp.edit();
//
//                    //以键值对的显示将用户名和密码保存到sp中
//                    ed.putString("spuserphone", my_phone);
//                    ed.putString("spuserpwd", my_pwd);
//
//                    //提交用户名和密码
//                    ed.commit();
                }


                break;
            case R.id.login_register:
               Intent intent1 = new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent1);

                break;
            case R.id.login_btn:

                my_phone = ed_Phone.getText().toString();
                  my_pwd = ed_Pwd.getText().toString();
                if (my_phone.isEmpty()||my_pwd.isEmpty()){
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } if (my_phone!=null&&my_pwd!=null){
                HashMap<String,String> prams=new HashMap<>();
                prams.put("phone",my_phone);
                prams.put("pwd",my_pwd);

                conPresenter.UserLoginPresenter(prams);
            }


                break;
        }

    }


    @Override
    public void UserLogin(LoginEntry loginEntry) {
        login_pan = loginEntry.getMessage();
//        sessionId = loginEntry.getResult().getSessionId();
//        userId = loginEntry.getResult().getUserId();
        if (login_pan.equals("登录成功")) {
            Toast.makeText(this, "" + login_pan, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            System.gc();
//            finish();
                       /* Intent   intent = new Intent(LoginActivity.this,MainActivity.class);
                        //EventBus.getDefault().postSticky(map);
                        startActivity(intent);*/
        } else {
            Toast.makeText(this, "" + login_pan, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void UserRegist(RegistEntry registEntry) {

    }
//    public void readAccount() {
//
//
//        //在用户名和密码的输入框中显示用户名和密码
//        ed_Phone.setText(spuserphone);
//        ed_Pwd.setText(spuserpwd);
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        conPresenter.onDestory();
    }


}
