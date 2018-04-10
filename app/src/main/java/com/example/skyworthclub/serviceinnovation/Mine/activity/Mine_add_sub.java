package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by 26792 on 2018/3/19.
 */

public class Mine_add_sub extends AppCompatActivity implements View.OnClickListener{
    EditText ad_text;
    EditText pr_text;
    EditText cycle_first_text;
    EditText cycle_second_text;
    EditText re_first_text;
    EditText re_second_text;
    ImageView back_button;
    Button finish_button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_add_sub);
        back_button=findViewById(R.id.mine_add_sub_title_back);
        finish_button=findViewById(R.id.mine_add_sub_button);
        ad_text=findViewById(R.id.address);
        pr_text=findViewById(R.id.projectName);
        cycle_first_text=findViewById(R.id.cy_first_et);
        cycle_second_text=findViewById(R.id.cy_second_et);
        re_first_text=findViewById(R.id.re_first_et);
        re_second_text=findViewById(R.id.re_second_et);
        back_button.setOnClickListener(this);
        finish_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
   switch (v.getId()){
       case R.id.mine_add_sub_title_back:
           onBackPressed();
           break;
       case R.id.mine_add_sub_button:
           Toast.makeText(this, "FINISH", Toast.LENGTH_SHORT).show();
           break;
           default: break;
   }
    }
}
