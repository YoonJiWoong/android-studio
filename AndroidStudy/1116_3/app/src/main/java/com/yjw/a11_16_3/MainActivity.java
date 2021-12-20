package com.yjw.a11_16_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
    }


    public void onclick(View v) {

        if (v.getId() == R.id.btn1) {

            if (et1.getText().toString().equals("a") && et2.getText().toString().equals("a")) {

                Toast.makeText(getApplicationContext(), "로그인 성공입니다.",
                        Toast.LENGTH_SHORT).show();



            }

        }else if (v.getId() == R.id.textView5) {

            Intent kakaoIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://youtu.be/fp6NrvO1Hso"));
            // ~~ 한 일을 하는 Intent 생성!!
            startActivity(kakaoIntent);


        }

    }

    public void tvClick(View v) {
        // 카카오 회원가입 페이지 띄운다!
        // Chrome 켜서 회원가입 url로 접속한다! (다른사람이 만든 어플 키는법!!)
        // ★★★★★★ Intent!!

        Intent kakaoIntent = new Intent(Intent.ACTION_VIEW, // 웹페이지 다른 엑티비티 어플 등을 만드는!!
                Uri.parse("https://accounts.kakao.com/weblogin/create_account/?continue=https%3A%2F%2Fcs.kakao.com%2Fhelps%3Fservice%3D52%26locale%3Dko#selectVerifyMethod"));
        // ~~ 한 일을 하는 Intent 생성!!

        // 인텐트 옵션들!!

        // Intent 실행시키는!!
        startActivity(kakaoIntent);


    }


}