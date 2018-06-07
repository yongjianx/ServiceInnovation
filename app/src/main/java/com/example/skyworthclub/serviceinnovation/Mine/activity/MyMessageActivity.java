package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.Mine.adapter.MessageDialogAdapter;
import com.example.skyworthclub.serviceinnovation.Mine.adapter.MyMessageAdapter;
import com.example.skyworthclub.serviceinnovation.R;

public class MyMessageActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mRvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);
        initView();
        getData();

    }

    private void initView() {
        RelativeLayout layout = findViewById(R.id.my_message_title);
        TextView textView = layout.findViewById(R.id.mine_add_sub_title_tv);
        textView.setText("我的消息");
        ImageView imageView = layout.findViewById(R.id.mine_add_sub_title_back);
        imageView.setOnClickListener(this);

        mRvMessage = findViewById(R.id.my_message_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvMessage.setLayoutManager(layoutManager);
        mRvMessage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        MyMessageAdapter adapter = new MyMessageAdapter(this);
        mRvMessage.setAdapter(adapter);
    }

    private void getData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_add_sub_title_back:
                onBackPressed();
                break;
        }
    }
}
