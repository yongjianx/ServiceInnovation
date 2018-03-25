package com.example.skyworthclub.serviceinnovation.Homepage.activity;

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
import com.example.skyworthclub.serviceinnovation.Homepage.view.SearchView;
import com.example.skyworthclub.serviceinnovation.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomepageSearch extends AppCompatActivity {
    private final String TAG = "HomepageSearch";

    private LinearLayout homepageSearch;
    private EditText editTextSearch;
    private TextView homepageBack;
    private View homepageHistory;

    private SearchView searchView;
    private TextView clearHistory;

    private VerticalItemAdapter verticalItemAdapter;
    //存放listView数据,耗时任务
    private Bitmap bitmap;
    private List<Bitmap> projectBitmap = new ArrayList<>();
    private HashMap<String, String> projectHashMap = new HashMap<>();
    private List<HashMap<String, String>> projectDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_search);
        init();
        searchView.setSpace(20, 20);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.homepage_android);
        //测试代码
        for (int i=0; i<5; i++){
            TextView textView = new TextView(this);
            textView.setText("hdoaqangeroge");
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            textView.setTextColor(getResources().getColor(R.color.colorBlack2));
            textView.setBackgroundResource(R.drawable.homepage_history_background);

            searchView.addView(textView);
        }
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

        homepageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                homepageSearch.removeView(homepageHistory);
                ListView listView = new ListView(HomepageSearch.this);
                listView.setLayoutParams(new WindowManager.LayoutParams
                        (WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT));

                verticalItemAdapter = new VerticalItemAdapter(HomepageSearch.this, projectDatas, projectBitmap);
                verticalItemAdapter.setOnItemClickListener(new VerticalItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(HomepageSearch.this, "you click projectItem"+position, Toast.LENGTH_SHORT).show();
                    }
                });
                listView.setAdapter(verticalItemAdapter);
                homepageSearch.addView(listView);
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
        homepageSearch = findViewById(R.id.homepage_search);
        editTextSearch = findViewById(R.id.homepage_editText_search);
        homepageBack = findViewById(R.id.homepage_back);
        homepageHistory = findViewById(R.id.homepage_history);

        searchView = findViewById(R.id.search_view);
        clearHistory = findViewById(R.id.clear_history);
    }
}
