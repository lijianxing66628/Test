package com.example.test.RecyclerView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.test.R;

/**
 * 歌单详情-歌曲适配器
 */
public class CommentAdapter extends BaseQuickAdapter<Comment, BaseViewHolder> {

    /**
     * 构造方法
     *
     * @param layoutResId 布局Id
     */
    public CommentAdapter(int layoutResId) {
        super(layoutResId);
    }

    /**
     * 显示数据
     *
     * @param helper
     * @param data
     */
    @Override
    protected void convert(@NonNull BaseViewHolder helper, Comment data) {
        helper.setText(R.id.tv,data.getName());
    }

}