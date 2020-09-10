package com.example.test.BANNER;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.MainActivity;
import com.example.test.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BannerFragemnt extends Fragment implements OnBannerListener {

    /**
     * 轮播图数据
     */
    private List<Ad> bannerData;

    @BindView(R.id.banner)
    Banner banner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_discovery,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());

        //设置轮播图显示得数据
        bannerData=new ArrayList<>();
        bannerData.add(new Ad("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=359648438,4114288232&fm=26&gp=0.jpg"));
        bannerData.add(new Ad("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=359648438,4114288232&fm=26&gp=0.jpg"));
        bannerData.add(new Ad("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=359648438,4114288232&fm=26&gp=0.jpg"));
        showBanner(bannerData);
    }
    /**
     * 显示轮播图数据
     *
     * @param data
     */
    private void showBanner(List<Ad> data) {
        this.bannerData = data;

        banner.setOnBannerListener(this);
        //设置到轮播图组件
        banner.setImages(data);

        //显示数据
        banner.start();

        //第一次也要滚动
        sartBannerScroll();
    }

    /***
     * 第一次也要滚动
     */
    private void sartBannerScroll() {
        banner.startAutoPlay();
    }

    /***
     * 当前界面展示了
     */
    @Override
    public void onResume() {
        super.onResume();
        if(bannerData!=null){
            //有数据才开始滚动
            sartBannerScroll();
        }
    }

    /**
     * 当界面看不见了执行
     *
     * 包括开启新界面，弹窗，后台
     */
    @Override
    public void onPause() {
        super.onPause();

        //结束轮播图滚动
        banner.stopAutoPlay();
    }

    /**
     * 轮播图点击回调
     *
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
        //获取到点击的广告对象
        Ad ad = bannerData.get(position);
        startActivity(new Intent(getActivity(), MainActivity.class));
        Toast.makeText(getActivity(), position+"", Toast.LENGTH_SHORT).show();
    }
}
