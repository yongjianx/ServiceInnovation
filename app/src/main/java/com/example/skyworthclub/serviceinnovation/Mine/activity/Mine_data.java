package com.example.skyworthclub.serviceinnovation.Mine.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skyworthclub.serviceinnovation.Main.activity.MainActivity;
import com.example.skyworthclub.serviceinnovation.Mine.adapter.MinedataAdapter;
import com.example.skyworthclub.serviceinnovation.Mine.utils.MineData;
import com.example.skyworthclub.serviceinnovation.R;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by 26792 on 2018/3/10.
 */

public class Mine_data extends AppCompatActivity implements View.OnClickListener{
    public  static final int CHOOSE_PHOTO=2;
    private List<MineData> mineData=new ArrayList<>();
    private TextView next;
    private ImageView back;
    private ImageView circleimage;
    private String TAG="Mine_data";
    LinearLayoutManager linearLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_data);
        next=findViewById(R.id.mine_data_title_next);
        back=findViewById(R.id.mine_data_title_back);
        circleimage=findViewById(R.id.mine_data_avatar);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        circleimage.setOnClickListener(this);
        initView();
        RecyclerView recyclerView=findViewById(R.id.mine_data_recyclerview);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MinedataAdapter adapter=new MinedataAdapter(mineData,this);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
//        从文件中读取数据
        SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
        String mname=preferences.getString("name","saujyun");
        String mgender=preferences.getString("gender","man");
        String  mnickname=preferences.getString("nickname","niu");
        String mresidence=preferences.getString("residence","huazhou");
        String mschool=preferences.getString("school","huagong");
        String mprofession=preferences.getString("profession","xingong");
        String mphone=preferences.getString("phone","15920128917");
        String mmail=preferences.getString("mail","2679225466@qq.com");
        Log.e(TAG, mname );
        MineData name=new MineData("姓名","#00D5DD",mname);
        MineData gender=new  MineData("性别","#FFEE58",mgender);
        MineData nikename=new  MineData("昵称","#FF6C72",mnickname);
        MineData residence=new  MineData("居住地","#4FC3F7",mresidence);
        MineData school=new  MineData("学校","#00D5DD",mschool);
        MineData profession=new  MineData("专业","#FFEE58",mprofession);
        MineData phone=new  MineData("手机","#FF6C72",mphone);
        MineData mail=new  MineData("邮箱","#4FC3F7",mmail);
        mineData.add(name);
        mineData.add(gender);
        mineData.add(nikename);
        mineData.add(residence);
        mineData.add(school);
        mineData.add(profession);
        mineData.add(phone);
        mineData.add(mail);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.mine_data_avatar: {
                 if (ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                 {
                     ActivityCompat.requestPermissions((Activity) v.getContext(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                 }else {
                     openAlbum();
                 }
                   break;
                 }
            case R.id.mine_data_title_back:{
                AlertDialog.Builder dialog=new AlertDialog.Builder(v.getContext());
                dialog.setMessage("直接退出所有修改将不做保存，是否确定退出修改");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //写退出操作
                        onBackPressed();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //回到编辑界面
                    }
                });
                dialog.show();
                break;
            }
            case R.id.mine_data_title_next:{
//                保存数据&跳转界面
                Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onClick: next");
//                saveData(linearLayoutManager);
                Intent intent=new Intent(v.getContext(),Mine_data_second.class);
                startActivity(intent);
                break;
            }
        }
    }
    // 数据保存
    public void saveData(LinearLayoutManager manager) {
        Log.e(TAG, "saveData: in savedata");
         SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                for (int position=0;position<=7;position++){
                    Toast.makeText(this, "mm", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "saveData: in for function");
//            获取recyclerview里面的itemview
                    View view=manager.findViewByPosition(position);
//            获取itemview里面edittext的实例
                    RelativeLayout layout=(RelativeLayout)view;
                    EditText editText=layout.findViewById(R.id.mine_data_edittext);
                    editor.clear().commit();
                    editor.putString(mineData.get(position).getName(), editText.getText().toString());
                    Log.e(TAG, "saveData: save");
                    editor.apply();
                }
            }

    private void openAlbum() {
        Intent intent=new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        Log.e(TAG, "openAlbum: error" );
        startActivityForResult(intent,CHOOSE_PHOTO);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String[]permissions,int[]grantResult){
        switch (requestCode){
            case 1:if (grantResult.length>0&&grantResult[0]==PackageManager.PERMISSION_GRANTED){
                openAlbum();
            }else {
                Toast.makeText(this, "you denied the premission", Toast.LENGTH_SHORT).show();
            }
            break;
            default:
        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        Log.e(TAG, "onActivityResult: onactivityresult");
        switch (requestCode){
            case  CHOOSE_PHOTO:{
                Log.e(TAG, "onActivityResult: in");
                if (resultCode==RESULT_OK){
                    if (Build.VERSION.SDK_INT>=19){
                        handleImageOnKitKat(data);
                    }else {
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            }
            default: Log.e(TAG, "onActivityResult: out");
            break;
        }
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagepath(uri, null);
        displayImage(imagePath);
    }
    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        Log.e(TAG, "handleImageOnKitKat: a");
            String imagepath=null;
            Uri uri=data.getData();
            if (DocumentsContract.isDocumentUri(this,uri)){
                String docID=DocumentsContract.getDocumentId(uri);
                if ("com.android.providers.media.documents".equals(uri.getAuthority())){
                    String id=docID.split(":")[1];
                    String selection=MediaStore.Images.Media._ID+"="+id;
                    imagepath=getImagepath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
                }else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                    Uri contenturi= ContentUris.withAppendedId(Uri.parse("content://download/public_downloads"),Long.valueOf(docID));
                    imagepath=getImagepath(contenturi,null);
                }else  if ("content".equalsIgnoreCase(uri.getScheme())){
                    imagepath=getImagepath(uri,null);
                }else if ("file".equalsIgnoreCase(uri.getScheme())){
                    imagepath=uri.getPath();
                }
                displayImage(imagepath);
            }
    }

    private void displayImage(String imagePath) {
        Log.e(TAG, "displayImage: display" );
        if (imagePath!=null){
            Toast.makeText(this, "change", Toast.LENGTH_SHORT).show();
            Bitmap bitmap= BitmapFactory.decodeFile(imagePath);
            circleimage.setImageBitmap(bitmap);
        }else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }

    private String getImagepath(Uri uri, String seletion) {
        String path=null;
        Cursor cursor=getContentResolver().query(uri,null,seletion,null,null);
        if (cursor!=null){
            if (cursor.moveToFirst()){
                path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }
}
