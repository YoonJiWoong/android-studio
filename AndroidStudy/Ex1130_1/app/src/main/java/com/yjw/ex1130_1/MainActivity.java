package com.yjw.ex1130_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ConstraintLayout ctl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        ctl = findViewById(R.id.layout);

//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SubActivity.class);


                // 갔다 오기~~ 왕복하기~!!
                startActivityForResult(intent, 416);
                // 채널??도 있는데 복잡하다!
                // 첫글자가 0이면 안되!! 정수형을 쓸때 첫글자가 0이면 8진수라고 생각해...??



            }
        });

    }

    // oncraete 바깥이지만 클래스 안에!!


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // requestCode => 1234
        // resultCode => RESULT_OK
        // date => new Intent().putExtra("color","#F5F5DC")
        if(requestCode==416) {
            if (resultCode == RESULT_OK) {
                String a = data.getStringExtra("color");
                ctl.setBackgroundColor(Color.parseColor(a));

            }
        }



    }




}