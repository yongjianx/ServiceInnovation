package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Mine.utils.Constant;
import com.example.skyworthclub.serviceinnovation.Mine.utils.NetworkUtil;
import com.example.skyworthclub.serviceinnovation.Mine.utils.ToastUtil;
import com.example.skyworthclub.serviceinnovation.R;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.title_back)
    ImageView mTitleBack;
    @BindView(R.id.mine_add_sub_title)
    RelativeLayout mMineAddSubTitle;
    @BindView(R.id.register_account_et)
    EditText mRegisterAccountEt;
    @BindView(R.id.delete_register_account_img)
    ImageView mDeleteRegisterAccountImg;
    @BindView(R.id.register_phone_et)
    EditText mRegisterPhoneEt;
    @BindView(R.id.delete_register_phone_img)
    ImageView mDeleteRegisterPhoneImg;
    @BindView(R.id.register_enter_confirm_et)
    EditText mRegisterEnterConfirmEt;
    @BindView(R.id.register_get_confirm_tv)
    TextView mRegisterGetConfirmTv;
    @BindView(R.id.register_password_et)
    EditText mRegisterPasswordEt;
    @BindView(R.id.delete_register_password_img)
    ImageView mDeleteRegisterPasswordImg;
    @BindView(R.id.notice_img)
    ImageView mNoticeImg;
    @BindView(R.id.register_confirm_password_et)
    EditText mRegisterConfirmPasswordEt;
    @BindView(R.id.delete_register_confirm_password_img)
    ImageView mDeleteRegisterConfirmPasswordImg;
    @BindView(R.id.register_btn)
    Button mRegisterBtn;
    @BindView(R.id.alert_password_layout)
    RelativeLayout mAlertLayout;

    private boolean mPasswordVisitable;
    private boolean mConfirmPasswordVisitable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mDeleteRegisterPasswordImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPasswordVisitable(mRegisterPasswordEt, mPasswordVisitable);
                mPasswordVisitable = !mPasswordVisitable;
            }
        });

        mDeleteRegisterConfirmPasswordImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPasswordVisitable(mRegisterConfirmPasswordEt, mConfirmPasswordVisitable);
                mConfirmPasswordVisitable = !mConfirmPasswordVisitable;
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = mRegisterPasswordEt.getText().toString();
                Pattern numPattern = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,100}$");
                Matcher numMatch = numPattern.matcher(password);
                Log.d("htout", "num:" + numMatch.matches());
                if (numMatch.matches()) {
                    if (password.equals(mRegisterConfirmPasswordEt.getText().toString())) {
                        String json = "{\"userName\":\"" + mRegisterAccountEt.getText().toString() + "\","
                                + "\"phoneNum\":\"" + mRegisterPhoneEt.getText().toString() + "\","
                                + "\"idCode\":\"" + mRegisterEnterConfirmEt.getText().toString() + "\","
                                + "\"rePassword\":\"" + mRegisterConfirmPasswordEt.getText().toString() + "\","
                                + "\"password\":\"" + mRegisterPasswordEt.getText().toString() + "\"}";
                        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
                        Request request = new Request
                                .Builder()
                                .post(requestBody)
                                .url(Constant.REGISTER_URL)
                                .build();
                        Call call = NetworkUtil.getOkhttpClient().newCall(request);
                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {

//                            final int resultCode = Integer.valueOf(response.body().string());
                                final String resultCode = response.body().string();
                                Log.d("htout", "code:" + resultCode);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (resultCode.equals("200")) {
                                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                            mAlertLayout.setVisibility(View.GONE);
                                            finish();
                                        } else if (resultCode.equals("-1")) {
                                            ToastUtil.show(RegisterActivity.this, "注册账号已存在");
                                        } else if (resultCode.equals("-2")) {
                                            ToastUtil.show(RegisterActivity.this, "验证码错误");
                                        }
                                    }
                                });
                            }
                        });

                    } else {
                        mAlertLayout.setVisibility(View.VISIBLE);
                    }
                } else {
                    ToastUtil.show(RegisterActivity.this, "密码过于简单");
                }
            }
        });

        mRegisterGetConfirmTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = mRegisterPhoneEt.getText().toString();
                String json = "{\"phoneNum\":\"" + phoneNum + "\"}";
                Call call = NetworkUtil.getCallByPost(Constant.GET_CODE_URL + phoneNum, json);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                    }
                });
            }
        });
    }

    private void setPasswordVisitable(EditText editText, boolean visiable) {
        if (!visiable) {
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            editText.setSelection(editText.getText().length());
        } else {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editText.setSelection(editText.getText().length());
        }
    }
}
