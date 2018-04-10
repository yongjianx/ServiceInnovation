package com.example.skyworthclub.serviceinnovation.Homepage.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Homepage.adapter.VerticalItemAdapter;
import com.example.skyworthclub.serviceinnovation.Homepage.utils.LimitQueue;
import com.example.skyworthclub.serviceinnovation.Homepage.utils.SharedPreferencesUtil;
import com.example.skyworthclub.serviceinnovation.Homepage.view.SearchView;
import com.example.skyworthclub.serviceinnovation.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HomepageSearch extends AppCompatActivity {
    private final String TAG = "HomepageSearch";

    private EditText editTextSearch;
    private TextView homepageBack;
    private SearchView searchView;
    private TextView clearHistory;

    private LimitQueue<String> limitQueue;
    private SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_search);
        init();
        //子view的间距
        searchView.setSpace(20, 20);

        limitQueue = new LimitQueue<String>(5);
        limitQueue.offer("sucess");

        sharedPreferencesUtil = new SharedPreferencesUtil(HomepageSearch.this);
        sharedPreferencesUtil.putObject(limitQueue, "history");

        //测试代码
        for (int i=0; i<5; i++){
            TextView textView = new TextView(this);
            textView.setText("hdoaqangeroge");
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            textView.setTextColor(getResources().getColor(R.color.colorBlack2));
            textView.setBackgroundResource(R.drawable.homepage_history_background);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomepageSearch.this, SearchResult.class);
                    startActivity(intent);
                }
            });

            searchView.addView(textView);
        }

        homepageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        clearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.removeAllViews();
            }
        });
    }

    public void init(){
        editTextSearch = findViewById(R.id.homepage_editText_search);
        homepageBack = findViewById(R.id.homepage_back);

        searchView = findViewById(R.id.search_view);
        clearHistory = findViewById(R.id.clear_history);
    }
}
