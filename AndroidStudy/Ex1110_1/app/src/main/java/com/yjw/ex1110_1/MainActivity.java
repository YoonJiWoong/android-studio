package com.yjw.ex1110_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ConstraintLayout a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        a= findViewById(R.id.A);


    }

    public void btnClick(View v){

        // 클릭 Event를 처리할 메소드는 반드시! 매개변수로 view를 갖고 있어야함.
        // => xml에서 onclick 속성 지정할 때 조회가 안됨.

        // Toggle 기능!
        // 1) 버튼을 누를때마다 숫자를 세어서 짝수인지 홀수 인지 판결!
        // - 짝수면 안녕!, 홀수면 Hello!            count!
        // 2) boolean 변수 사용해서 true <-> false 누를때마다 바꾸기
        // - true 면 안녕! false 면 Hello!          boolean!
        // 3) textview에 적힌 문자를 가져와서 판별!
        // - Hello! -> 안녕!, 안녕!-> Hello!


        if(v.getId() == R.id.button){
            tv.setText("안녕하세요!");
        }else if(v.getId() == R.id.button2){
            tv.setText("총으로 쏘기전에!");
        }else if(v.getId() == R.id.button3){
            tv.setText("여러분~ 리슨~~!!");
        } else if(v.getId() == R.id.button4){
            a.setBackgroundColor(Color.parseColor("#FF5675"));
            tv.setBackgroundColor(Color.BLUE);
        }else if(v.getId() == R.id.button5){
            a.setBackgroundColor(Color.BLUE);
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundColor(Color.YELLOW);
        }else if(v.getId() == R.id.button6){
            a.setBackgroundColor(Color.YELLOW);
            tv.setBackgroundColor(Color.RED);
        }else if(v.getId() == R.id.button7){
            if(tv.getText().equals("안녕하세요!")){ // 만약에 tv에 적힌 글자가 hello! 와 같다면!
                tv.setText("Hi!");
            }else if(tv.getText().toString().equals("총으로 쏘기전에!")){ // toString() 꼭 붙여줘!! int형변환도 string 바꾼 후에!
                tv.setText("Before I shoot!");
            }else if(tv.getText().equals("여러분~ 리슨~~!!")){ // 그렇지 않고 만약에!
                tv.setText("Everyone, listen!");
            }else if(tv.getText().equals("Hello World!")){
                tv.setText("안녕하세요!");
            }
            // else{} -> 그게 아니라면!!
            /* 카운트로 하는 방법으로도 할 수 있고!!
            count =0 이라고 쓰고...
            else if (v.getId() == R.id.button7) {
                count++;
                if(count==1){
                    tv_result.setText("★");
                }
                else if(count==2){
                    tv_result.setText("☆");
                }
                else if(count==3){
                    tv_result.setText("◆");
                    count=0;
                }
            }
           */



        }


    }


}