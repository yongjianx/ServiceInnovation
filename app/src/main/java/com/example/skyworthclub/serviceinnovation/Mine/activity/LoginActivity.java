package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.Mine.bean.UserInfo;
import com.example.skyworthclub.serviceinnovation.Mine.utils.Constant;
import com.example.skyworthclub.serviceinnovation.Mine.utils.NetworkUtil;
import com.example.skyworthclub.serviceinnovation.Mine.utils.ToastUtil;
import com.example.skyworthclub.serviceinnovation.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends Activity {

    public static final int LOGIN_SUCCESS = 10;

    private EditText mAccountEt;
    private EditText mPasswordEt;
    private ImageView mDeleteAccountImg;
    private ImageView mDeletePasswordImg;
    private Button mLoginBtn;
    private TextView mForgetPasswordTv;
    private ImageView mBackImg;
    private TextView mRegisterTv;

    private boolean mIsPasswordSee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        mAccountEt = (EditText) findViewById(R.id.account_et);
        mPasswordEt = (EditText) findViewById(R.id.password_et);
        mDeleteAccountImg = (ImageView) findViewById(R.id.delete_account_img);
        mDeletePasswordImg = (ImageView) findViewById(R.id.delete_password_img);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mForgetPasswordTv = (TextView) findViewById(R.id.forget_password_tv);
        mBackImg = (ImageView) findViewById(R.id.title_back);
        mRegisterTv = (TextView) findViewById(R.id.register_title_tv);

        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mRegisterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mDeletePasswordImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsPasswordSee) {
                    mPasswordEt.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mPasswordEt.setSelection(mPasswordEt.getText().length());
                    mIsPasswordSee = true;
                } else {
                    mPasswordEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mPasswordEt.setSelection(mPasswordEt.getText().length());
                    mIsPasswordSee = false;
                }
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = "{\"identity\":\"" + mAccountEt.getText().toString() + "\","
                        + "\"password\":\"" + mPasswordEt.getText().toString() + "\"}";
                Call call = NetworkUtil.getCallByPost(Constant.LOGIN_URL, json);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        final String data = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                UserInfo userInfo = gson.fromJson(data, UserInfo.class);
                                SharedPreferences sharedPreferences = getSharedPreferences("Account ID", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("account name", userInfo.getUsername());
                                editor.commit();
                                setResult(LOGIN_SUCCESS);
                                finish();
                            }
                        });
                    }
                });
            }
        });

        mForgetPasswordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }


}
