package com.yjw.ex1201_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 카톡 메세지 구성~~ => ArrayList에 담기~~
    // 그런데! 카톡 메세지 하나에는 정보가 3개 들어감! (시간의 경우 데이터 4개)
    // 이미지 리소스 => int
    // 보낸 사람 => String
    // 메세지 => String
    // int, String, String을 한 묶음으로 만들 수 있는 자료형이 없네??
    // 사용자가 정의한 새로운 자료형을 만들어 내자!!
    // => Value Object => VO

    private Button btn1;
    private ListView listView;
    private EditText et1;
    ArrayList<ChatVO> data = new ArrayList<ChatVO>();



    FirebaseDatabase database = FirebaseDatabase.getInstance("https://and-1e97b-default-rtdb.asia-southeast1.firebasedatabase.app/"); // 서버 URL
    DatabaseReference myRef = database.getReference("message");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn_send);
        listView = findViewById(R.id.listview);
        et1 = findViewById(R.id.edt_msg);

        Intent intent = getIntent();
        String et = intent.getStringExtra("et1");


        data.add(new ChatVO(R.drawable.img1,"김철수","안녕하세요"));
        data.add(new ChatVO(R.drawable.img2,"홍길동","반갑습니다"));
        data.add(new ChatVO(R.drawable.img3,"아이유","hello"));
        data.add(new ChatVO(R.drawable.img4,"짭스","시리야ㅋㅋㅋㅋ"));
        data.add(new ChatVO(R.drawable.img5,"재드래곤","빅스비ㅋㅋㅋㅋㅋ"));

        ChatAdapter chatAdapter = new ChatAdapter(getApplicationContext(),R.layout.borad,data);
        // 컨택스트, 디자인한 xml, data
        listView.setAdapter(chatAdapter);

        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String a = et1.getText().toString();
               if(!a.equals("")){

                   myRef.push().setValue(new ChatVO(R.drawable.img5,et,et1.getText().toString()));

                   manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                   //   data.add(new ChatVO(R.drawable.img5,"재드래곤",et1.getText().toString()));
                   //   서버에 연동하니깐 지워버려
                   //    2) adapter 새로고침!

                   et1.setText("");
                   chatAdapter.notifyDataSetChanged();

               }
               else{
                   manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

               }



           }
       });


        // FireBase DateBase 경로에 데이터가 바뀐것을 감지한다!
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // 메시지 추가된거 감지하는 메소드!
                // 1. 추가된 데이터를 받아 올 때! ChatVO 형태로 받아옴!
                // 2. ChatVO에 default 생성자 (매개변수 없는 생성자)와 setter 메소드 만들어져 있어야 함!
                ChatVO temp = dataSnapshot.getValue(ChatVO.class);
                data.add(temp);
                chatAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // 변경된걸 감지

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                // 삭제된걸 감지
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // 이동했을때
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 에러났을때
            }
        });


        // 지난 시간에는~~ 데이터가 String 밖에 없었고
        // 템플릿도 TextView 밖에 없었어서
        // 기본으로 제공해주는 ArrayAdapter 사용 할 수 있었다!

        // 하지만! 오늘은 데이터도 복잡해졌고 (다른 자료형이 3개나 되고!)
        // 템플릿도 훨씬 복잡해졌다!

        // 해결방법 => BaseAdapter를 상속받아서 나만의 Adapter를 설계해야함.
        // (CustomListView!!!   커스텀 리스트뷰)

        // Adapter 생성하고 ListView 셋텅


    }
}