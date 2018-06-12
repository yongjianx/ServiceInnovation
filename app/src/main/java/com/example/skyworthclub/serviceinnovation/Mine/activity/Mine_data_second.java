package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.content.Context;
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
import com.example.skyworthclub.serviceinnovation.R;

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

        back_button.setOnClickListener(this);
        finish_text.setOnClickListener(this);
        mRvDownloadFile = findViewById(R.id.download_file_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvDownloadFile.setLayoutManager(layoutManager);
        mRvDownloadFile.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new DownloadFileAdapter();
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
}
