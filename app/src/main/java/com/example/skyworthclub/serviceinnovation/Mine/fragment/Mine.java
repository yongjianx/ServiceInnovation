package com.example.skyworthclub.serviceinnovation.Mine.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Mine.activity.Mine_resume;
import com.example.skyworthclub.serviceinnovation.R;

/**
 * Created by skyworthclub on 2018/1/21.
 */

public class Mine extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_main, container, false);
        textView=view.findViewById(R.id.mine_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"click",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(), Mine_resume.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
