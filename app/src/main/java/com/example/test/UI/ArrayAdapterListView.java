package com.example.test.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArrayAdapterListView extends AppCompatActivity {

    @BindView(R.id.mList_View)
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_list_view);
        ButterKnife.bind(this);
        //准备集合数据
        String[] data={"A","B","C","D","E","F","G","H","I","J","K","L"};
        //准备ArrayAdapter对象
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.item_array_adapter,data);
        //设置Adapter显示列表
        listView.setAdapter(adapter);
    }
}
