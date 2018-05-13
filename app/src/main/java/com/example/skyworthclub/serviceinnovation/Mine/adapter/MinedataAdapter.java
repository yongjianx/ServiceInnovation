package com.example.skyworthclub.serviceinnovation.Mine.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.skyworthclub.serviceinnovation.Mine.utils.MineData;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by 26792 on 2018/3/17.
 */

public class MinedataAdapter extends RecyclerView.Adapter<MinedataAdapter.ViewHolder>  {
    private Context context;
    private final List<MineData> mineDatas;
    private String[] sexArry=new String[]{"女","男"};
    public MinedataAdapter(List<MineData> mineData,Context context){
        this.mineDatas=mineData;
        this.context=context;
    }
    @Override
    public MinedataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_data_recyclerview,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.editTexts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                switch (position){
                    case 1: {
                        AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                        builder.setSingleChoiceItems(sexArry, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                holder.editTexts.setText(sexArry[which]);
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                    }

                    default: break;
            }
        }
        });

        return holder;
    }


    @Override
    public void onBindViewHolder(MinedataAdapter.ViewHolder holder, int position) {
       MineData mineData=mineDatas.get(position);
       holder.textView.setText(mineData.getName());
       holder.views.setBackgroundColor(Color.parseColor(mineData.getMcolor()));
       if (mineData.getMedittext()!=null) {
           holder.editTexts.setText(mineData.getMedittext());
       }
    }

    @Override
    public int getItemCount() {
        return mineDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public EditText editTexts;
        private TextView textView;
        private View views;
        public ViewHolder(View itemView) {
            super(itemView);
           editTexts=itemView.findViewById(R.id.mine_data_edittext);
           textView=itemView.findViewById(R.id.mine_data_moudle);
           views=itemView.findViewById(R.id.mine_data_view);
        }
    }
}
