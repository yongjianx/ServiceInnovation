package com.example.skyworthclub.serviceinnovation.Mine.activity;


import android.content.Context;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.utils.SharedPreferencesUtil;
import com.example.skyworthclub.serviceinnovation.Mine.adapter.DownloadFileAdapter;
import com.example.skyworthclub.serviceinnovation.Mine.utils.Constant;
import com.example.skyworthclub.serviceinnovation.Mine.utils.NetworkUtil;
import com.example.skyworthclub.serviceinnovation.Mine.utils.ToastUtil;
import com.example.skyworthclub.serviceinnovation.R;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 26792 on 2018/3/18.
 */

public class Mine_data_second extends AppCompatActivity implements View.OnClickListener {
    ImageView back_button;
    TextView finish_text;
    EditText editText_first;
    EditText editText_second;
    private RecyclerView mRvDownloadFile;
    private DownloadFileAdapter mAdapter;
    SharedPreferencesUtil sharedPreferencesUtil;

    private ArrayList<String> mFileNameList;
    private TextView mAddFileTv;
    private ImageView mAddFileImg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_data_next);

        back_button = findViewById(R.id.mine_data_title_back);
        finish_text = findViewById(R.id.mine_data_title_next);
        editText_first = findViewById(R.id.first_interval);
        editText_second = findViewById(R.id.second_intervals);
        //        避免光标出现，让edittext失去焦点
        finish_text.setFocusable(true);
        finish_text.setFocusableInTouchMode(true);
        finish_text.requestFocus();

        mAddFileTv = findViewById(R.id.add_file_tv);
        mAddFileImg = findViewById(R.id.add_file);
        mAddFileTv.setOnClickListener(this);
        mAddFileImg.setOnClickListener(this);
        mFileNameList = new ArrayList<String>();
        mFileNameList.add("Skyworth.rar");
        mFileNameList.add("Skyworth.rar");
        mFileNameList.add("Skyworth.rar");

        back_button.setOnClickListener(this);
        finish_text.setOnClickListener(this);
        mRvDownloadFile = findViewById(R.id.download_file_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvDownloadFile.setLayoutManager(layoutManager);
        mRvDownloadFile.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new DownloadFileAdapter(this, mFileNameList);
        mRvDownloadFile.setAdapter(mAdapter);
        sharedPreferencesUtil = new SharedPreferencesUtil(getBaseContext());
        intView();
    }

    private void intView() {
        if (sharedPreferencesUtil.getString("et_first") != null || sharedPreferencesUtil.getString("et_second") != null) {
            editText_first.setText(sharedPreferencesUtil.getString("et_first"));
            editText_second.setText(sharedPreferencesUtil.getString("et_second"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_data_title_back:
                onBackPressed();
                break;

            case R.id.mine_data_title_next:
                Toast.makeText(this, "完成", Toast.LENGTH_SHORT).show();
                String et_first = editText_first.getText().toString();
                String et_second = editText_second.getText().toString();
                sharedPreferencesUtil.putString("et_first", et_first);
                sharedPreferencesUtil.putString("et_second", et_second);
                hideSoftInput(v.getWindowToken());//关闭软键盘

            case R.id.add_file:
            case R.id.add_file_tv:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);
                break;
            default:

                break;
        }

    }


    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                Uri uri = data.getData();
                Call call = NetworkUtil.getCallByPostForm(Constant.UPLOAD_FILE_URL, uri.getPath().toString());
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.show(Mine_data_second.this, "上传失败");
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.show(Mine_data_second.this, "上传成功");
                            }
                        });
                    }
                });
                Toast.makeText(this, "文件路径：" + uri.getPath().toString(), Toast.LENGTH_SHORT).show();
            }

        }
    }
}
