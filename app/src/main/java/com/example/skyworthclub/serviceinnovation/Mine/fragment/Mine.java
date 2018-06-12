package com.example.skyworthclub.serviceinnovation.Mine.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Mine.activity.LoginActivity;
import com.example.skyworthclub.serviceinnovation.Mine.activity.Mine_add_sub;
import com.example.skyworthclub.serviceinnovation.Mine.activity.Mine_data;
import com.example.skyworthclub.serviceinnovation.Mine.activity.Mine_resume;
import com.example.skyworthclub.serviceinnovation.Mine.activity.MyMessageActivity;
import com.example.skyworthclub.serviceinnovation.Mine.activity.MySubscribeActivity;
import com.example.skyworthclub.serviceinnovation.Mine.utils.Constant;
import com.example.skyworthclub.serviceinnovation.Mine.utils.NetworkUtil;
import com.example.skyworthclub.serviceinnovation.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class Mine extends Fragment implements View.OnClickListener {

    public static final int LOGIN_REQUEST = 8;
    ImageView setting;
    ImageView avatar;

    RelativeLayout mine_part2;
    RelativeLayout mine_part3;
    RelativeLayout mine_part4;
    RelativeLayout mine_part5;

    private boolean mHasLogin;
    private String mUserName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_main, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        setting=view.findViewById(R.id.mine_setting);
        avatar=view.findViewById(R.id.mine_avatar);
        mine_part2=view.findViewById(R.id.mine_part2);
        mine_part3=view.findViewById(R.id.mine_part3);
        mine_part4=view.findViewById(R.id.mine_part4);
        mine_part5=view.findViewById(R.id.mine_part5);
        mine_part2.setOnClickListener(this);
        mine_part3.setOnClickListener(this);
        mine_part4.setOnClickListener(this);
        mine_part5.setOnClickListener(this);
        setting.setOnClickListener(this);
        avatar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_setting:{
                Toast.makeText(v.getContext(), "setting", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.mine_part2:{
                Toast.makeText(v.getContext(), "data", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),Mine_data.class);
                String data="minelayout";
                intent.putExtra("extra_data",data);
                startActivity(intent);
                break;
            }
            case R.id.mine_part3:{
                Toast.makeText(v.getContext(), "resume", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),Mine_resume.class);
                startActivity(intent);
                break;
            }
            case R.id.mine_part4:{
                Toast.makeText(v.getContext(), "subscribe", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),MySubscribeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.mine_part5: {
                Toast.makeText(v.getContext(), "info", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),MyMessageActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.mine_avatar:
                if (mHasLogin) {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(1)
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                } else {
                    Intent intent=new Intent(v.getContext(),LoginActivity.class);
                    startActivityForResult(intent, LOGIN_REQUEST);
                }
                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    Bitmap bm = BitmapFactory.decodeFile(selectList.get(0).getPath());
                    avatar.setImageBitmap(bm);
                    String filePath = "";
                    Call call = NetworkUtil.getCallByPostForm(Constant.UPLOAD_PHOTO_URL + "/" + mUserName, filePath);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {

                        }
                    });
                    break;
                case LOGIN_REQUEST:
                    if (resultCode == LoginActivity.LOGIN_SUCCESS) {
                        mHasLogin = true;
                    }
            }
        }
    }
}
