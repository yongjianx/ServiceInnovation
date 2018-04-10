package com.example.skyworthclub.serviceinnovation.Homepage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 * Created by skyworthclub on 2018/4/10.
 */

public class SharedPreferencesUtil {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesUtil(Context context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public boolean putString(String key, String string){
        editor.putString(key, string);
        return editor.commit();
    }

    public boolean putInt(String key, int num){
        editor.putInt(key, num);
        return editor.commit();
    }

    public boolean putFloat(String key, float num){
        editor.putFloat(key, num);
        return editor.commit();
    }

    public boolean putBoolean(String key, boolean value){
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public boolean putLong(String key, long value){
        editor.putLong(key, value);
        return editor.commit();
    }

    public boolean putStringSet(String key, Set<String> values){
        editor.putStringSet(key, values);
        return editor.commit();
    }

    /*
    remove 输出已存储的数据
    @params key 键值
     */
    public boolean remove(String key){
        editor.remove(key);
        return editor.commit();
    }

    public boolean clear(){
        editor.clear();
        return editor.commit();
    }

    /*
    putBitmap 存储图片
    @params bitmap 要存储的图片对象
    @params key 图片对象的key值
    @return true保存成功，false失败
     */
    public boolean putBitmap(Bitmap bitmap, String key){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //压缩图片
        bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
        String bitmapString = new String(Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        editor.putString(key, bitmapString);
        return editor.commit();
    }

    /*
    getBitmap 获取图片对象
    @params key 图片对象的键值
     */
    public Bitmap getBitmap(String key){
        String bitmapString = sharedPreferences.getString(key, "");
        Bitmap bitmap = null;
        if (!bitmapString.equals("")){
            byte[] bytes = Base64.decode(bitmapString.getBytes(), 1);
            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            return bitmap;
        }
        return null;
    }

    /*
    putObject 存储对象
    @params object 要存储的对象
    @params key 对象的键值
     */
    public boolean putObject(Object object, String key){
        if (object == null){
            editor.remove(key);
            return editor.commit();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try{
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

        String objectString = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        try{
            byteArrayOutputStream.close();
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        editor.putString(key, objectString);
        return editor.commit();
    }

    /*
    getObject 获取对象
    @params key 对象的键值
     */
    public Object getObject(String key){
        String objectString = sharedPreferences.getString(key, "");
        if (objectString == null || objectString.equals(""))
            return null;
        byte[] bytes = Base64.decode(objectString.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            return object;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
