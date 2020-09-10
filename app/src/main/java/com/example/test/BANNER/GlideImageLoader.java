package com.example.test.BANNER;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

/**
 * Banner框架显示图片的实现类
 *
 * 如果有其他位置用到
 * 可以放到单独的文件中
 */
public class GlideImageLoader extends ImageLoader {
    /**
     * 加载图片的方法
     *
     * @param context
     * @param path
     * @param imageView
     */
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //将对象转为广告对象
        Ad banner = (Ad) path;

        //显示图片
        Glide.with(context)
                .load(banner.getBanner())
                .into(imageView);
    }

}