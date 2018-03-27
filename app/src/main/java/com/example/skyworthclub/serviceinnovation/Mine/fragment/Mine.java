package com.example.skyworthclub.serviceinnovation.Mine.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Mine.activity.Mine_add_sub;
import com.example.skyworthclub.serviceinnovation.Mine.activity.Mine_data;
import com.example.skyworthclub.serviceinnovation.Mine.activity.Mine_resume;
import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class Mine extends Fragment implements View.OnClickListener {
    ImageView data;
    ImageView subscribe;
    ImageView resume;
    ImageView info;
    ImageView setting;
    ImageView avatar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_main, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        setting=view.findViewById(R.id.mine_setting);
        data=view.findViewById(R.id.mine_data_button);
        subscribe=view.findViewById(R.id.mine_sub_button);
        resume=view.findViewById(R.id.mine_resume_button);
        info=view.findViewById(R.id.mine_info_button);
        avatar=view.findViewById(R.id.mine_avatar);
        setting.setOnClickListener(this);
        data.setOnClickListener(this);
        subscribe.setOnClickListener(this);
        resume.setOnClickListener(this);
        info.setOnClickListener(this);
        avatar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_setting:{
                Toast.makeText(v.getContext(), "setting", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.mine_data_button:{
                Toast.makeText(v.getContext(), "data", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),Mine_data.class);
                startActivity(intent);
                break;
            }
            case R.id.mine_resume_button:{
                Toast.makeText(v.getContext(), "resume", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),Mine_resume.class);
                startActivity(intent);
                break;
            }
            case R.id.mine_sub_button:{
                Toast.makeText(v.getContext(), "subscribe", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),Mine_add_sub.class);
                startActivity(intent);
                break;
            }
            case R.id.mine_info_button:{
                Toast.makeText(v.getContext(), "info", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(v.getContext(),Mine_data.class);
//                startActivity(intent);
                break;
            }
        }

    }
}
