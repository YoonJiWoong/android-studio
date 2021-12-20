package com.yjw.ex1201_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private Button btn1;
    private Button btn2;

    RequestQueue requestQueue; // 전송 통로
    StringRequest stringRequest_join; // 전송할 데이터, URL ,설정(get/post) 등 담는 바구니!
    StringRequest stringRequest_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);



        // 1. 통로 생성 ~
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        // 2. 전송할 URL String 변수에 저장
        String url = "http://222.102.104.190:8088/MemberServer2/JoinServlet";

        // 3. StringRequest 만들기~
        // - 메게변수 4개~ 1 : 전송방식, 2 : url, 3 : 응답리스너, 4 : 에러리스너
        stringRequest_join = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 응답을 처리하는 곳!
                // 회원가입 성공 했으면 성공! 이라고 Toast 메시지 띄우기!
                // 회원가입 실패했으면 ID를 다시 확인하세요!~ 라고 Toast 띄우기!

                if(response.equals("1")){
                    Toast.makeText(login.this, "회원가입성공", Toast.LENGTH_LONG).show();

                }else if(response.equals("0")){
                    Toast.makeText(login.this, "회원가입실패", Toast.LENGTH_LONG).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //
                HashMap<String, String> params = new HashMap<>();
                params.put("id",et1.getText().toString());
                params.put("pw",et2.getText().toString());

                return params;

            }
        };

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 쏘자!
                requestQueue.add(stringRequest_join);

            }
        });


        String url1 = "http://222.102.104.190:8088/MemberServer2/LoginServlet";


        stringRequest_login = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("true")){
                    Toast.makeText(login.this, "로그인성공", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(login.this, MainActivity.class);
                    intent.putExtra("et1",et1.getText().toString());
                    intent.putExtra("et2",et2.getText().toString());
                    startActivity(intent);

                }else{
                    Toast.makeText(login.this, "로그인실패", Toast.LENGTH_LONG).show();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>(); // KEY값 VALUE 값
                params.put("id",et1.getText().toString());
                params.put("pw",et2.getText().toString());
                return params;
            }
        };

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestQueue.add(stringRequest_login);


            }
        });




    }
}