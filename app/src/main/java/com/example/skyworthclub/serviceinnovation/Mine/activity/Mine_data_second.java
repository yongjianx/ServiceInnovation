package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
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

import java.util.ArrayList;

/**
 * Created by 26792 on 2018/3/18.
 */

public class Mine_data_second extends AppCompatActivity implements View.OnClickListener {
    ImageView back_button;
    TextView  finish_text;

    private RecyclerView mRvDownloadFile;
    private DownloadFileAdapter mAdapter;
    private ArrayList<String> mFileNameList;
    private TextView mAddFileTv;
    private ImageView mAddFileImg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_data_next);
        mAddFileTv = findViewById(R.id.add_file_tv);
        mAddFileImg = findViewById(R.id.add_file);
        mAddFileTv.setOnClickListener(this);
        mAddFileImg.setOnClickListener(this);
        mFileNameList = new ArrayList<String>();
        mFileNameList.add("Skyworth.rar");
        mFileNameList.add("Skyworth.rar");
        mFileNameList.add("Skyworth.rar");
        back_button=findViewById(R.id.mine_data_title_back);
        finish_text=findViewById(R.id.mine_data_title_next);
        back_button.setOnClickListener(this);
        finish_text.setOnClickListener(this);
        mRvDownloadFile = findViewById(R.id.download_file_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvDownloadFile.setLayoutManager(layoutManager);
        mRvDownloadFile.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new DownloadFileAdapter(this, mFileNameList);
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
                break;
            case R.id.add_file:
            case R.id.add_file_tv:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent,1);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                Uri uri = data.getData();
                Toast.makeText(this, "文件路径："+uri.getPath().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
