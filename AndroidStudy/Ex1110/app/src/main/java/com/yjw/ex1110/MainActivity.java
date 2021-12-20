package com.yjw.ex1110;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    private EditText et;

    @Override
    // Activity(화면(App)) 실행될 떄 최초 1번만 호출되는 메소드!
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml 파일 화면에 띄우는 코드! 지우면 안되고! 위치도고정 !
        // 반드시 위에 두 줄은 반드시 맨 위에 있어야 함!

        tv_result = findViewById(R.id.textView);
        et =  findViewById(R.id.edt_input);

    }




    // 클릭 Event 처리하기
    // 1) 버튼을 클릭했을 때 실행될 메소드 설계해놓기~
    // 2) 버튼과 btnClick 메소드 연결하기~ => 버튼의 onclick 속성에 btnClick 메소드 설정하기
    public void btnClick(View v){
        // 매개변수 View v
        // => 클릭이 일이넌 버튼!
        // v의 아이디를 안다면 그걸로 구분!
        if(v.getId() == R.id.button){
            tv_result.setText("안녕하세요!");
        }else if(v.getId() == R.id.button3){
            tv_result.setBackgroundColor(Color.parseColor("#3949AB" ));
        }else if(v.getId() == R.id.button4){
            tv_result.setText(et.getText().toString());
        }


        // TextView 글자 바꾸기
        // 1) TextView 찾아오기! => id값

        // TextView tv_result = findViewById(R.id.textView);

        // 2) 속성 바꾸기


    }
    public void btnClick3(View v){
        // TextView 글자 바꾸기
        // 1) TextView 찾아오기! => id값

        // TextView tv_result = findViewById(R.id.textView);

        // 2) 속성 바꾸기

        // tv_result.setBackgroundColor(Color.parseColor("#3949AB" ));

        // AndroidStudio 의 Syso! Log 찍는 법!
        Log.v("검색어! 아무거나 해도 됨!","출력하고 싶은 데이터!"); // 메서드 안에?

    }

    public void btnClick4(View v){
        // 입력한 글자로 TextView 글자 바꾸기
        // 1) 버튼에 Event 처리 해주기
        // 2) 버튼 눌렀을때 EditText에 적힌 글자 가져오기
        // 3) TextView 글자 바꾸기


        // TextView tv_result = findViewById(R.id.textView);

       // EditText et =  findViewById(R.id.edt_input);



        //////////////////////////////////////////////////////////
        // String A = et.getText().toString();
        // tv_result.setText(A);
        // tv_result.setText(et.getText())
        // et.getText().toString() : toString() 안해줘도 됨!!

    }

    public void btnClick2(View v1){
        // TextView 글자 바꾸기
        // 1) TextView 찾아오기! => id값

        ConstraintLayout a = findViewById(R.id.A);

        // 2) 속성 바꾸기

        a.setBackgroundColor(Color.RED);

    }

}