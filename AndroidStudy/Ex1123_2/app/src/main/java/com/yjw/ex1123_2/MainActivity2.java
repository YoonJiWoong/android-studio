package com.yjw.ex1123_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv1;
    private TextView tv11;
    private TextView tv2;
    private TextView tv22;
    private TextView tv3;
    private TextView tv33;
    private TextView tv4;
    private TextView tv44;
    private TextView tv5;
    private TextView tv55;
    private TextView tv6;
    private TextView tv66;
    private TextView tvtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        tv1=findViewById(R.id.tv1);
        tv11=findViewById(R.id.tv11);
        tv2=findViewById(R.id.tv2);
        tv22=findViewById(R.id.tv22);
        tv3=findViewById(R.id.tv3);
        tv33=findViewById(R.id.tv33);
        tv4=findViewById(R.id.tv4);
        tv44=findViewById(R.id.tv44);
        tv5=findViewById(R.id.tv5);
        tv55=findViewById(R.id.tv55);
        tv6=findViewById(R.id.tv6);
        tv66=findViewById(R.id.tv66);
        tvtext=findViewById(R.id.tvtext);



        Random rd = new Random();
        String num[] = new String[6];
        for(int i=0; i<num.length;i++){

            num[i]=rd.nextInt(46)+1+"";

            for(int j=0; j<i; j++){
                if(num[i]==num[j]){
                    i--;
                }
            }
        }



        tv1.setText(num[0]);
        tv2.setText(num[1]);
        tv3.setText(num[2]);
        tv4.setText(num[3]);
        tv5.setText(num[4]);
        tv6.setText(num[5]);



            Intent intent = getIntent();
        String text1 = intent.getStringExtra("input1");
        String text2 = intent.getStringExtra("input2");
        String text3 = intent.getStringExtra("input3");
        String text4 = intent.getStringExtra("input4");
        String text5 = intent.getStringExtra("input5");
        String text6 = intent.getStringExtra("input6");

        String textarray[] = new String[6];
        textarray[0]=text1;
        textarray[1]=text2;
        textarray[2]=text3;
        textarray[3]=text4;
        textarray[4]=text5;
        textarray[5]=text6;

        tv11.setText(text1);
        tv22.setText(text2);
        tv33.setText(text3);
        tv44.setText(text4);
        tv55.setText(text5);
        tv66.setText(text6);

        int count=0;
        for(int i=0; i<num.length; i++){
            for(int j=0; j<textarray.length;j++){
                if(num[i].equals(textarray[j])){
                    count++;
                }
            }
        }

        if(count==6){
            tvtext.setText("1등입니다.");
        }else if(count==5){
            tvtext.setText("2등입니다.");
        }else if(count==4){
            tvtext.setText("3등입니다.");
        }else{
            tvtext.setText("다음기회에");
        }




    }
}