package com.example.zhongshifeng.shiyansan;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements
        OnClickListener{
    EditText txt;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button neibu = (Button) findViewById(R.id.neibu);
        Button waibu = (Button) findViewById(R.id.waibu);
        Button niming = (Button) findViewById(R.id.niming);
        Button activity = (Button) findViewById(R.id.activity);
        Button bangding = (Button) findViewById(R.id.bangding);
        txt=(EditText)findViewById(R.id.xianshi);
        class MyClickListener implements OnClickListener{
                public void onClick(View v){
                    EditText txt=(EditText)findViewById(R.id.xianshi);
                    txt.setText("内部类");
                }
        }
        class ExtentEvent implements OnClickListener{
            private Activity act;
            private ExtentEvent txt;
            public ExtentEvent(Activity act,ExtentEvent txt){
                this.act=act;
                this.txt=txt;
            }
            public void onClick(View v){
                txt.settext("外部类");
            }
        }
        neibu.setOnClickListener(new MyClickListener());
        waibu.setOnClickListener(new ExtentEvent(this,txt));
        niming.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                txt.setText("匿名内部类");

            }
        });
        activity.setOnClickListener(this);
    }
    public void clickHandler(View source){
        EditText et =(EditText)findViewById(R.id.xianshi);
        et.setText("绑定到标签");
    }
    public void onClick(View v){
        txt.setText("Activict");
    }
    public class FirstFragment extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
            View view=inflater(R.layout.anniu,container,false);
            return view;
        }
    }
    public class SencondFragment extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
            View view=inflater(R.layout.xianshi,container,false);
            return view;
        }
    }









}