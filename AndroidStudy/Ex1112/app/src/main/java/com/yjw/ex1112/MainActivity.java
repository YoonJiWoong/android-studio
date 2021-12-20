package com.yjw.ex1112;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    // 현재 이미지에는 순서가 없어요! (연속적이지 않음)
    // 순서가 없는 데이터에 순서를 만들어주고 싶으면 배열에 넣어주면 됨!
    // 이미지들의 R.drawable.image1 <- 배열에 넣고싶다!...
    // 그런다면 배열 타입은 ???

    int images[]={R.drawable.a1,R.drawable.a2,R.drawable.a3};
    int currentCnt = 0; // 현재 보여질 이미지의 번호!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img= findViewById(R.id.imageView);

    }
/*
    public void onClick(View v){

        if(v.getId() == R.id.button){
            img.setImageResource(R.drawable.a1);
        }else if(v.getId() == R.id.button2){
            img.setImageResource(R.drawable.a2);
        }else if(v.getId() == R.id.button3){
            img.setImageResource(R.drawable.a3);
        }

    }
*/

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button:
              // img.setImageResource(R.drawable.a1);
                currentCnt=0;
                break;
            case R.id.button2:
             //   img.setImageResource(R.drawable.a2);
                currentCnt=1;
                break;
            case R.id.button3:
            //    img.setImageResource(R.drawable.a3);
                currentCnt=2;
                break;
            case R.id.btn_next:
                // currentCnt 하나 증가시키고
                // currentCnt 번째 이미지 set

          /*      if(currentCnt==images.length-1){
                    currentCnt= -1;
                } */

                currentCnt++;

                if(currentCnt ==images.length){
                    Toast.makeText(getApplicationContext(), "마지막 이미지 입니다.",
                            Toast.LENGTH_SHORT).show();

                    currentCnt=images.length-1;
                }

            //    img.setImageResource(images[currentCnt]);

                break;


            case R.id.btn_pre:

           /*     if(currentCnt==0){
                    currentCnt= images.length;
                } */

                currentCnt--;


                if(currentCnt == -1){
                    Toast.makeText(getApplicationContext(), "처음 이미지 입니다.",
                            Toast.LENGTH_SHORT).show();
                    currentCnt =0;

                }

                break;

        }

        img.setImageResource(images[currentCnt]);

    }



}