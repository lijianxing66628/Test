package com.example.test.ACTIVITY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Iphone extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    @BindView(R.id.ibtn1)
    Button btn1;
    @BindView(R.id.ibtn2)
    Button btn2;
    @BindView(R.id.iedit1)
    EditText edit1;
    @BindView(R.id.iedit2)
    EditText edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iphone);
        ButterKnife.bind(this);
        setEvent();
    }
    public void setEvent(){
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn1.setOnLongClickListener(this);
        btn2.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn1){
            Intent intent=new Intent(Intent.ACTION_DIAL);
            int number=120;
            intent.setData(Uri.parse("tel:"+number));
            startActivity(intent);
        }else if(v==btn2){
            Intent intent=new Intent(Intent.ACTION_SENDTO);
            int number=120;//电话号码
            intent.setData(Uri.parse("smsto:"+number));
            intent.putExtra("sms_body","李华");//李华(短信内容)
            startActivity(intent);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v==btn1){
//            Intent intent=new Intent(Intent.ACTION_CALL);
//            int number=120;
//            intent.setData(Uri.parse("tel:"+number));
//            startActivity(intent);
        }else if(v==btn2){
            //得到SmsManager的对象
            SmsManager smsManager=SmsManager.getDefault();
            //发送文本信息
            String number="110";
            String value="李华";
            smsManager.sendTextMessage(number,null,value,null,null);
        }
        return true;
    }
}
