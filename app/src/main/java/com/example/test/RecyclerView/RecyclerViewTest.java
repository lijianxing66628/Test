package com.example.test.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewTest extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    CommentAdapter adapter;
    List<Comment> comments;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        //尺寸固定
        rv.setHasFixedSize(true);

        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(RecyclerViewTest.this);
        rv.setLayoutManager(layoutManager);
        //创建分割线
       DividerItemDecoration decoration=new DividerItemDecoration(RecyclerViewTest.this,RecyclerView.VERTICAL);
       //添加到控件
       //可以添加多个
       rv.addItemDecoration(decoration);
        //创建适配器
        adapter = new CommentAdapter(R.layout.item_song_detail);
        comments=new ArrayList<>();
        comments.add(new Comment("dslkjf"));
        comments.add(new Comment("dlsjfldsf"));
        comments.add(new Comment("dlkjfaldsfklsafj"));
        comments.add(new Comment("dlkfsjfd"));
        //设置适配器
        rv.setAdapter(adapter);
       next();

   }
    /**
     * 显示数据
     */
    private void next() {

        if (comments.size()>0) {
            //有音乐才设置

            //设置数据
            adapter.replaceData(comments);
        } else {
            adapter.replaceData(new ArrayList<>());
        }
    }

}
