package com.example.skyworthclub.serviceinnovation.Homepage.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.adapter.VerticalItemAdapter;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchResult extends AppCompatActivity {
    private final static String TAG = "SearchResultActivity";

    private LinearLayout MainSearchResult;
    private ImageView back;
    private EditText editText;
    private TextView search;

    private VerticalItemAdapter verticalItemAdapter;
    //存放listView数据,耗时任务
    private Bitmap bitmap;
    private List<Bitmap> projectBitmap = new ArrayList<>();
    private HashMap<String, String> projectHashMap = new HashMap<>();
    private List<HashMap<String, String>> projectDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();
        //获取从上一个activity传过来的搜索内容
        Intent intent = getIntent();
        editText.setText(intent.getStringExtra("searchContent"));

        //测试用
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.homepage_android);
        for (int i=0; i<4; i++){
            //listView
            projectHashMap.clear();
            projectHashMap.put("projectName", "创维俱乐部");
            projectHashMap.put("releaseTime", "2018-1-10");
            projectHashMap.put("companyName", "腾讯");
            projectHashMap.put("address", "深圳");
            projectHashMap.put("time", "6个月");
            projectHashMap.put("money", "5000");
            projectDatas.add(projectHashMap);
            projectBitmap.add(bitmap);
        }
        addView();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                Log.e(TAG, s);
            }
        });
    }

    private void init(){
        MainSearchResult = findViewById(R.id.homepage_search_result);
        back = findViewById(R.id.homepage_search_result_back);
        editText = findViewById(R.id.homepage_editText_search_result);
        search = findViewById(R.id.homepage_result_back);
    }

    private void addView(){
        ListView listView = new ListView(SearchResult.this);
        listView.setLayoutParams(new WindowManager.LayoutParams
                (WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT));

        verticalItemAdapter = new VerticalItemAdapter(SearchResult.this, projectDatas, projectBitmap);
        verticalItemAdapter.setOnItemClickListener(new VerticalItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(SearchResult.this, "you click projectItem"+position, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(verticalItemAdapter);
        MainSearchResult.addView(listView);
    }
}
