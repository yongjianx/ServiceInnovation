package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.skyworthclub.serviceinnovation.Mine.View.RecyclerViewItemDivider;
import com.example.skyworthclub.serviceinnovation.Mine.adapter.SubscribeAdapter;
import com.example.skyworthclub.serviceinnovation.R;

public class MySubscribeActivity extends AppCompatActivity {

    private RecyclerView mRvSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_subscribe);
        initView();
    }

    private void initView() {
        mRvSubscribe = findViewById(R.id.subscribe_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvSubscribe.setLayoutManager(layoutManager);
        mRvSubscribe.addItemDecoration(new RecyclerViewItemDivider());
        SubscribeAdapter adapter = new SubscribeAdapter();
        mRvSubscribe.setAdapter(adapter);
    }
}
