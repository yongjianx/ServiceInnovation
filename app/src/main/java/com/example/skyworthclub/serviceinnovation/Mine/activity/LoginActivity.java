package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

public class LoginActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        mAccountEt = findViewById(R.id.account_et);
        mPasswordEt = findViewById(R.id.password_et);
        mDeleteAccountImg = findViewById(R.id.delete_account_img);
        mDeletePasswordImg = findViewById(R.id.delete_password_img);
        mLoginBtn = findViewById(R.id.login_btn);
        mForgetPasswordTv = findViewById(R.id.forget_password_tv);
        mBackImg = findViewById(R.id.title_back);
        mRegisterTv = findViewById(R.id.register_title_tv);

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
    }
}
