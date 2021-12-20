package com.yjw.ex1119;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Event 처리하는 두번째 방법!
    // 1. xml에서 onClick 속성으로 Event 메소드 연결~
    // 2. java 만 사용해서 Event 메소드 연결~
    // 2-1) Event 걸고 싶은 버튼 찾아오기
    // 2-2) setonClick 메소드 호출하기
    // 2-3) OnClcikListener 구현하기

    private Button btn_camera;
    private Button btn_call;
    private Button btn_next;
    private EditText edt_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2-1) Event 걸고 싶은 버튼 찾아오기
        btn_camera = findViewById(R.id.btn_camera);
        btn_call = findViewById(R.id.btn_call);
        btn_next = findViewById(R.id.btn_next);

        edt_input = findViewById(R.id.edt_input);

        // 2-2) setonClick 메소드 호출하기
        btn_camera.setOnClickListener(new View.OnClickListener() {
            // 인터페이스 -> 인터페이스 안에는 추상메서드 -> 오버라이딩 (반드시 구현해줘야한다!)
            @Override
            public void onClick(View v) {

                // 액션(행위), 데이터
                Intent ca_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(ca_intent);   // startActivities(); -여러개 실행할떄

                // 콜백메서드 연결해주겠다.
                // Listener 뭔가 감지하겠다!!
                // btn_camera.setOnLongClickListener(); -> 길게 클릭하겠다!

                // 2-3) OnClcikListener 구현하기

            }

        });

        btn_call.setOnClickListener(new View.OnClickListener() { // new 쓰고 On 클릭!! new 꼭 써줄것!
            @Override
            public void onClick(View v) {

                // 전화걸기

                // 권한 승인받기! (CALL 권한!)
                // 1) Manifest 파일에 permission 코드 입력하기!
                // 2) 권한 부여 받았는지 검사해서 부여된 권한이 없다면
                //      승인해달라고 Dialog 띄우기

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {  // 숫자 =0 허용되어있지않다면
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, 0);
                } else {//권한이 승인되어 있다면
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01094249887")); // tel에 띄어쓰기 있음 안되!
                    startActivity(intent);                                          // 데이터타입:실제이터 -> 마인타입
                }


            }
        });

        // 리스너 이벤트를 감지하는애... : OnClickListener 이용해서 연결

        // subActivity로 가는 버튼에 listener 달아주기~
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // subActivity로 이동~
                // 1) 페이지 이동하고 싶을 때 Intent안에 넣어줄 것
                // - 보내는 Activity(출발지), 받는 Activity (도착지)


                // edt_input 에 적힌 글자 가져와서
                String text = edt_input.getText().toString(); // 아래로 적으면 안되!! 보내고 나서 값을 가져와서...

                // 택배 상자 준비
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                // 물건 넣기(key, Value)
                // 데이터 여러개 넣고 싶다면?? putExtra 여러번 호출하면 됨~~ (key값 다르게 해서)
                intent.putExtra("input",text);



                // 우체국에 보내주기~
                startActivity(intent);

            }
        });

 /*       2) 두번째 페이지로 데이터 전송하기
        2-1) 버튼을 눌렀을 때
        2-2) edt_input에 적힌 글자 가져오고
        2-3) Intent에 담아서 => putExtra (K,V)
        2-4) 보내준다. => startActivity(intent0).


        2-5) 보낸 Intent 가져와서
        2-6) 데이터 꺼낸다.
*/


    }





}

