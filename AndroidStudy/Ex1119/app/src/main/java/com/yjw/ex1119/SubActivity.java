package com.yjw.ex1119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    private Button btn_main;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        // activity_sub 의 화면을 출력한다.

        Intent intent = getIntent();
        String text = intent.getStringExtra("input");

        // getStringExtra => 매개변수 1개 (name 값만 넣어주면 됨!)
        // String text = getIntent().getStringExtra("input"); 이리 1줄로 써도 되!

        // getIntExtra => 매개변수 2개 (name, defaultValue)
        // defaultValue?? 해당하는 name의 값이 없을때 사용 될 기본 값!

        int temp = getIntent().getIntExtra("intvalue", -1);

        textView = findViewById(R.id.textView);

        textView.setText("받아온값은"+text+"입니다."+temp);

        btn_main = findViewById(R.id.btn_main);
        // setContentView가 있어서 해당 페이지 안에서 찾아서 같은 id도 구분해서 찾을 수 있어



        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ** task에 새로운 Activity를 쌓는 명령어!
                // Intent intent = new Intent(SubActivity.this, MainActivity.class);
                // startActivity(intent);
                // startActivity(new Intent(SubActivity.this, MainActivity.class));

                // ** task에서 현재 Activity 삭제하는 명령어!
                finish();


            }
        });

    }




}