package com.yjw.ex1113_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    int cnt1=0;
    int cnt2=0;
    int img[] = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    private ImageView img1;
    private ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1=findViewById(R.id.tx1);
        tv2=findViewById(R.id.tx2);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);

    }

    public void onClick(View v){

        if(v.getId()==R.id.btn) {
            // rd_num1 : 첫번째 주사위에 띄울 이미지 번호!
            // rd_num2 :

            int rd_num1 = 0;
            int rd_num2 = 0;
            Random rd = new Random();
            rd_num1 = rd.nextInt(img.length);
            rd_num2 = rd.nextInt(6); // 나중되면 어려우니깐 첫번째 방법으로!!
            img1.setImageResource(img[rd_num1]);
            img2.setImageResource(img[rd_num2]);

            if (rd_num1 > rd_num2) {
                cnt1++;
            } else if (rd_num1 < rd_num2) {
                cnt2++;
            }else{
                // 진동 울려보기!~ (휴대폰 센서 사용해보기)
                // 1) 진동권한 부여하기~
                // 2) 센서 객체 획득하기~
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // 3) 진동울리기~~
                long[] pattern = {100,300,100,300,100,100,300,100,300,100};
                // 진동, 대기, 진동, 대기, 진동, 대기 1초울리고 3초쉬고 이런느낌..!
                vibe.vibrate(pattern,-1);
                // 2번째 매개변수는 반복할지 안할지~ 0: 무한반복,-1반복없음



            }




        }

        if(v.getId()==R.id.btn2){
            cnt1=0;
            cnt2=0;

        }

        tv2.setText(cnt1 + ":" + cnt2);

    }





}