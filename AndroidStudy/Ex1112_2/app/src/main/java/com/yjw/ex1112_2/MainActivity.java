package com.yjw.ex1112_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_cnt;
    int count=0; // 버튼 누를때마다 - 또는 + 시킬 숫자!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_cnt=findViewById(R.id.tv_cnt);

    }
/*
    public void onclick(View v){

        if(v.getId() == R.id.btn_minus){
            count--;
            tv_cnt.setText("연산결과:"+String.valueOf(count));

        } else if(v.getId()==R.id.btn_plus){
            count++;
            tv_cnt.setText("연산결과:"+String.valueOf(count));

        }

    }
*/

    public void btnClick(View v){
        switch (v.getId()){

            case R.id.btn_minus:
                count--;
                break;
            case R.id.btn_plus:
                count++;
                break;
        }

        tv_cnt.setText(count+"");
        // tv_cnt.setText(String.valueOf(count));

        // ★★★★★
        // setText에는 정수값을 넣을 수 없음!
        // why?
        // 정수를 넣으면 id 값이라고 생각함.
        // 리소스 (이미지, 뷰의 id, 문자열)들은 고유 id를 가지고 있는데
        // 고유 id는 정수형!! 이다.
        // => R파일에 등록된 id는 int 정수형이다!! (정확하게는 상수??)
        int minusID = R.id.btn_minus;  // 이해용!!

    }




}