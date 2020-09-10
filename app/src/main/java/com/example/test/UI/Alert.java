package com.example.test.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.drm.ProcessedData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.test.R;

import java.util.Calendar;

import butterknife.BindView;

public class Alert extends AppCompatActivity {

    @BindView(R.id.abtn1)
    Button btn1;
    @BindView(R.id.abtn2)
    Button btn2;
    @BindView(R.id.abtn3)
    Button btn3;
    @BindView(R.id.abtn4)
    Button btn4;
    @BindView(R.id.abtn5)
    Button btn5;
    @BindView(R.id.abtn6)
    Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }

    public void showAd(View v){
        new AlertDialog.Builder(this)
                .setTitle("删除数据")//设置标题
                .setMessage("你确定删除数据吗？")
                .setPositiveButton("删除",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Alert.this,"删除数据",Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Alert.this,"取消删除数据",Toast.LENGTH_LONG).show();
                    }
                })
                .show();//方法链调用
    }

    public void showAdA(View view) {
        String[] items={"红","栏","绿","灰"};
        new AlertDialog.Builder(this)
                .setTitle("指定背景颜色")
                .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {//第二个参数是默认数组下标
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Alert.this,items[which],Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                })
                .show();
    }


    public void showCD(View v){
        View view=View.inflate(this,R.layout.layout_alert,null);
        final EditText ET1=view.findViewById(R.id.aedit1);
        final EditText ET2=view.findViewById(R.id.aedit2);
        new AlertDialog.Builder(this)
                .setView(view)
                .setNegativeButton("取消",null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Alert.this, ET1.getText().toString()+ET2.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public void showPro(View view) {
        final ProgressDialog dialog=ProgressDialog.show(this,"数据加载","数据加载中...");
        new Thread(){
            public void run(){
                for(int i=0;i<20;i++){
                    //休息一会
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();//调用Handler主线程清楚
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Alert.this, "加载完成了", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();

    }

    public void showHPro(View view) {
        //创建dialog对象
        ProgressDialog pd=new ProgressDialog(this);
        //设置样式
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //显示
        pd.show();
        //启动线程，显示加载进度，移除dialog
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count=20;
                //设置最大进度
                pd.setMax(count);
                for(int i=0;i<20;i++){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pd.setProgress(pd.getProgress()+1);
                }
                //移除dialog
                pd.dismiss();
            }
        }).start();
    }

    public void showDate(View view) {

        //创建日期对象
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH+1);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.e("TAG",year+month+day+"");
            }
        },year,month,day).show();
    }

    public void showTime(View view) {
        //创建日期对象
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        },hour,minute,true).show();
    }
}
