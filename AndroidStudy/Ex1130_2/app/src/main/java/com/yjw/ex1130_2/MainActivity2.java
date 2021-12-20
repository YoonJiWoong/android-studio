package com.yjw.ex1130_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText edt1;
    private EditText edt2;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edt1 = findViewById(R.id.etd1);
        edt2 = findViewById(R.id.etd2);
        btn1 = findViewById(R.id.btn1);

//        String id=edt1.getText().toString();
//        String pw=edt2.getText().toString();
//         -> 로딩될때가 아니라 글자를 클릭할때 글자를 가져와야 하니깐

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String id=edt1.getText().toString();
               String pw=edt2.getText().toString();
               if(id.equals("a")&&pw.equals("a")){
                   Toast.makeText(MainActivity2.this, "로그인 성공!",Toast.LENGTH_SHORT).show();
                   // getApplicationContext(); MainActivity2.this 이게 더 큰 개념...
                   setResult(RESULT_OK, new Intent().putExtra("nickname",id));
                   finish();
               }
               else{
                   Toast.makeText(MainActivity2.this, "ID와 PW를 다시 확인해주세요!",Toast.LENGTH_SHORT).show();
               }

            }
        });



    }
}