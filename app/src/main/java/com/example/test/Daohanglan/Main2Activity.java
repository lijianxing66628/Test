package com.example.test.Daohanglan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnStyle1;
    private Button mBtnStyle2;
    private Button mBtnStyle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mBtnStyle1 = findViewById(R.id.style1_btn);
        mBtnStyle2 = findViewById(R.id.style2_btn);
        mBtnStyle3 = findViewById(R.id.style3_btn);
        mBtnStyle1.setOnClickListener(this);
        mBtnStyle2.setOnClickListener(this);
        mBtnStyle3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.style1_btn:
                startActivity(new Intent(Main2Activity.this, Style1Activity.class));
                break;

            default:
                break;
        }
    }
}