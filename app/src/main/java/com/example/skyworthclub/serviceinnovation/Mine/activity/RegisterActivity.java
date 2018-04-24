package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.title_back)
    ImageView mTitleBack;
    @BindView(R.id.register_title_tv)
    TextView mRegisterTitleTv;
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
