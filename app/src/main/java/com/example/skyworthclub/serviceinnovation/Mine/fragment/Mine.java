package com.example.skyworthclub.serviceinnovation.Mine.fragment;

import android.content.Intent;
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
import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class Mine extends Fragment implements View.OnClickListener {
    ImageView setting;
    ImageView avatar;

    RelativeLayout mine_part2;
    RelativeLayout mine_part3;
    RelativeLayout mine_part4;
    RelativeLayout mine_part5;

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
                Intent intent=new Intent(v.getContext(),LoginActivity.class);
                startActivity(intent);
                break;
        }

    }
}
