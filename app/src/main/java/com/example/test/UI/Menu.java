package com.example.test.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu extends AppCompatActivity {

    @BindView(R.id.mbtn2)
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }
}
