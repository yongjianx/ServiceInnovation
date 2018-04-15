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
import android.widget.ImageView;
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
    //队列固定长度
    private final static int limit = 5;
    //两条搜索记录之间的横向间距
    private final static int horizontalSpace = 40;
    //两条搜索记录之间的纵向间距
    private final static int verticalSpace = 30;
    //搜索记录的总数
    private int queueSize = 0;

    private ImageView back;
    private EditText editTextSearch;
    private TextView search;
    private SearchView searchView;
    private TextView clearHistory;
    private SearchView hotSearch;

    //存储新添加的搜索记录
    private List<String> searchList;
    private LimitQueue<String> queue;
    private SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_search);
        init();
        //子view的间距
        searchView.setSpace(horizontalSpace, verticalSpace);

        searchList = new ArrayList<>();
        sharedPreferencesUtil = new SharedPreferencesUtil(HomepageSearch.this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomepageSearch.this, "click", Toast.LENGTH_SHORT).show();
                String s = editTextSearch.getText().toString();
                s = s.replace(" ", "");
                if (!s.equals(""))
                    searchList.add(s);
            }
        });
        clearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清空所有的view,同时把sharedPreferences的搜索历史数据清除
                searchView.removeAllViews();
                sharedPreferencesUtil.remove("history");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        queue = (LimitQueue<String>) sharedPreferencesUtil.getObject("history");
        if (queue != null){
            Log.e(TAG, "limitQueue的大小："+queue.getSize());

            if (queue.getSize() > queueSize){
                for (int i=queueSize; i<queue.getSize(); i++){
                    TextView textView = new TextView(this);
                    textView.setText(queue.get(i));
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
            }

            //记录上次搜索记录的总数
            queueSize = queue.getSize();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //将新增加的搜索记录添加到原来的队列中
        if (searchList.size() != 0){
            if (queue == null)
                queue = new LimitQueue<>(limit);
            for (int i=0; i<searchList.size(); i++){
                queue.offer(searchList.get(i));
            }
            searchList.clear();
            sharedPreferencesUtil.putObject(queue, "history");
        }

    }

    public void init(){
        back = findViewById(R.id.homepage_search_back);
        editTextSearch = findViewById(R.id.homepage_editText_search);
        search = findViewById(R.id.homepage_back);

        searchView = findViewById(R.id.search_view);
        clearHistory = findViewById(R.id.clear_history);
        hotSearch = findViewById(R.id.hot_search);
    }
}
