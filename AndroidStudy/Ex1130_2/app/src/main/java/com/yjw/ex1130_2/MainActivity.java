package com.yjw.ex1130_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_write;
    private TextView txt1;
    private ListView ListView;
    //1) 기억을 더듬어 String을 저장할 수 있는 ArrayList 생성!
    ArrayList<String> al = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_write = findViewById(R.id.btn_write);
        txt1 = findViewById(R.id.txt1);
        ListView = findViewById(R.id.ListView);

        //2) 개시글 5개 생성
        al.add("여러분 내일 지각 없으면");
        al.add("초밥사준데여~");
        al.add("게시글3");
        al.add("게시글 444444");
        al.add("몰라여");

        // Adapter 생성
        // Adapter 의 역활
        // => 데이터(글, 사진)를 템플릿(xml)에다가 set 시키고
        // => ListView에 하나하나 적재~~
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getApplicationContext(),
                        R.layout.borad, al); // getApplicationContext(),템플릿,데이터

        // ListView에 adapter 설정~~
        ListView.setAdapter(adapter);
        // 글자크기 바꾸고 시팓고 리스트뷰에 설정하는거 아니야!!
        // xml에서 고쳐야...디자인 고쳐야


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn_login.getText().toString().equals("로그인")) {


//                    btn_write.setEnabled(true);
//                    btn_login.setText("로그아웃");


                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                    // 갔다 오기~~ 왕복하기~!!
                    startActivityForResult(intent, 416);

                } else {
                    btn_write.setEnabled(false);
                    btn_login.setText("로그인");
                    txt1.setText("글쓰기는 로그인 후 가능합니다.");

                }

            }
        });

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 글이 추가되야 함!
                // 1) ArrayList에 글을 추가하고
                al.add((al.size()+1)+" .Android 재밌음!!!");
                // 2) adapter 새로고침!
                adapter.notifyDataSetChanged();

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==416 && resultCode==RESULT_OK) { // 로그인 버튼 눌러서 갔다 왔을때
                String a = data.getStringExtra("nickname"); // 나한테 온 택배
                txt1.setText(a+"님 환영합니다");
             //   txt1.setText(getIntent().getStringExtra("id")); 집에온 택배

            btn_write.setEnabled(true);
            btn_login.setText("로그아웃");

        }


    }
}