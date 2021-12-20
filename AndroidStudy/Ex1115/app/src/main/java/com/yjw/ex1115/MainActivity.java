package com.yjw.ex1115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    // 선 연결할때
    // 상하 (좌우) 중 하나만 연결하면 절대적인 여백으로 위치 결정!(실선)
    // 절대적인 여백으로 위치 결정!
    // 화면이 더 커지거나 작아지면 내가 원하는 위치가 아닐 수도 있다!

    // 상하 (좌우) 전부 연결해주면 비율(bias)로 위치를 결정!
    // 화면이 더 커지거나 작아져도 일정한 위치 유지 가능!
    // 대신! 다른 뷰와 겹칠 수도 있음!!

}