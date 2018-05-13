package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.skyworthclub.serviceinnovation.Mine.adapter.MessageDialogAdapter;
import com.example.skyworthclub.serviceinnovation.R;

public class MessageDialogActivity extends AppCompatActivity {

    private RecyclerView mRvMessageDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_dialog);
        initView();
    }

    private void initView() {
        ImageView imageView = findViewById(R.id.title_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ImageView unSubscribeImg = findViewById(R.id.unsubscribe_title_img);
        unSubscribeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mRvMessageDialog = findViewById(R.id.message_dialog_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvMessageDialog.setLayoutManager(layoutManager);
        MessageDialogAdapter adapter = new MessageDialogAdapter();
        mRvMessageDialog.setAdapter(adapter);
    }
}
