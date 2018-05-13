package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Mine.adapter.DownloadFileAdapter;
import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by 26792 on 2018/3/18.
 */

public class Mine_data_second extends AppCompatActivity implements View.OnClickListener {
    ImageView back_button;
    TextView  finish_text;

    private RecyclerView mRvDownloadFile;
    private DownloadFileAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_data_next);
        back_button=findViewById(R.id.mine_data_title_back);
        finish_text=findViewById(R.id.mine_data_title_next);
        back_button.setOnClickListener(this);
        finish_text.setOnClickListener(this);
        mRvDownloadFile = findViewById(R.id.download_file_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvDownloadFile.setLayoutManager(layoutManager);
        mRvDownloadFile.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new DownloadFileAdapter();
        mRvDownloadFile.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_data_title_back:
                onBackPressed();
                break;
            case  R.id.mine_data_title_next:
                Toast.makeText(this, "finish", Toast.LENGTH_SHORT).show();
        }

    }
}
