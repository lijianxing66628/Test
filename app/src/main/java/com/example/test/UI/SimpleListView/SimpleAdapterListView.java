package com.example.test.UI.SimpleListView;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.test.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleAdapterListView extends AppCompatActivity {
    List<ShopInfo> data=new ArrayList<ShopInfo>();
    @BindView(R.id.list_view)
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_list_view);
        ButterKnife.bind(this);
        //准备数据集合
        for (int i = 0; i < 10; i++) {
            data.add(new ShopInfo(R.drawable.ic_launcher_background,"name"+i,"content"+i));
        }
        //准备BaseAdapter对象
        Myadapter adapter=new Myadapter();
        //设置Adapter显示列表
        listView.setAdapter(adapter);
    }
    class Myadapter extends BaseAdapter{

        //返回集合数量
        @Override
        public int getCount() {
            return data.size();
        }
        //返回指定下标的数据对象
        @Override
        public Object getItem(int position) {
            return data.get(position);
        }
        //返回指定下标的item的对象
        @Override
        public long getItemId(int position) {
            return 0;
        }
        /*
        * 返回指定下标的item的view的对象
        * parent是ListView
        * */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=View.inflate(SimpleAdapterListView.this,R.layout.item_simple_adapter,null);
            //根据position设置数据
            ImageView imageView=view.findViewById(R.id.image);
            TextView textView1=view.findViewById(R.id.text1);
            TextView textView2=view.findViewById(R.id.text2);
            imageView.setImageResource(data.get(position).getIcon());
            textView1.setText(data.get(position).getName());
            textView2.setText(data.get(position).getContent());
            return view;
        }
    }
}
