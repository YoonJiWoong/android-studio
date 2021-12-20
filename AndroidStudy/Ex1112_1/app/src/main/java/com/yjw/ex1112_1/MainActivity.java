package com.yjw.ex1112_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    int num1;
    int num2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.ed1);
        et2 = findViewById(R.id.ed2);
        tv = findViewById(R.id.textView);



    }



    public void onClick(View v){

        num1 = Integer.parseInt(et1.getText().toString());
        num2 = Integer.parseInt(et2.getText().toString());

        if(v.getId()==R.id.button){
           tv.setText("연산결과:"+String.valueOf(num1+num2));
        }else if(v.getId()==R.id.button2){
            tv.setText("연산결과:"+String.valueOf(num1-num2));
        }else if(v.getId()==R.id.button3){
            tv.setText("연산결과:"+String.valueOf(num1*num2));
        }else if(v.getId()==R.id.button4){
            tv.setText("연산결과:"+String.valueOf(num1/num2));
        }


    }




}