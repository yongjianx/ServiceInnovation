package com.example.skyworthclub.serviceinnovation.Homepage.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.Homepage.view.SearchView;
import com.example.skyworthclub.serviceinnovation.R;

import org.w3c.dom.Text;

public class HomepageSearch extends AppCompatActivity {
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_search);
        searchView = findViewById(R.id.search_view);
        searchView.setSpace(20, 20);

        for (int i=0; i<5; i++){
            TextView textView = new TextView(this);
            textView.setText("hdoaqangeroge");
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            textView.setTextColor(getResources().getColor(R.color.colorBlack2));

            textView.setBackgroundResource(R.drawable.homepage_history_background);

            searchView.addView(textView);
        }
    }
}
