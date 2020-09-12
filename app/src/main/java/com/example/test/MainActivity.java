package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.ACTIVITY.Iphone;
import com.example.test.BANNER.Main3Activity;
import com.example.test.Glide.GlideActivity;
import com.example.test.RecyclerView.RecyclerViewTest;
import com.example.test.UI.Alert;
import com.example.test.UI.ArrayAdapterListView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    private void init() {

    }

    @OnClick({R.id.mbtn1,R.id.mbtn2,R.id.mbtn3,R.id.mbtn4,R.id.mbtn5,R.id.mbtn6,R.id.mbtn7})
    public void onClick(View v) {
        if(v.getId()==R.id.mbtn1){
            Intent intent=new Intent(MainActivity.this, Iphone.class);
            startActivity(intent);
        }else if(v.getId()==R.id.mbtn2){
            Intent intent=new Intent(MainActivity.this, Alert.class);
            startActivity(intent);
        }else if(v.getId()==R.id.mbtn3){
            Intent intent=new Intent(MainActivity.this, ArrayAdapterListView.class);
            startActivity(intent);
        }else if(v.getId()==R.id.mbtn4){
            Intent intent=new Intent(MainActivity.this, GlideActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.mbtn5){
        } else if(v.getId()==R.id.mbtn6){
            startActivity(new Intent(MainActivity.this, Main3Activity.class));
        }else if(v.getId()==R.id.mbtn7){
            startActivity(new Intent(MainActivity.this, RecyclerViewTest.class));
        }
    }
    protected void startActivityN(Class<?> clazz) {
        //创建Intent
        Intent intent = new Intent(MainActivity.this, clazz);

        //启动界面
        startActivity(intent);
    }
}
