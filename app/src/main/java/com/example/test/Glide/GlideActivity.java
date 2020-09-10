package com.example.test.Glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideActivity extends AppCompatActivity {

    @BindView(R.id.glide1)
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
//        Glide.with(this).load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1588080998&di=8c0934e494d0bcd4ffd4bef88792afcb&src=http://pic3.16pic.com/00/01/11/16pic_111395_b.jpg").into(imageView);
//        Glide.with(this).load(R.drawable.ic_launcher_background).into(imageView);
        Glide.with(this).load(R.drawable.loading).placeholder(R.mipmap.ic_launcher).into(imageView);

    }
}
