package com.yjw.ex1130_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        listview = findViewById(R.id.listview);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // AdapterView<?> parent LIST뷰 전체 / 리스튜 안에 3개 들어있어 -  View view 내가 누른 텍스트 뷰/
                // int postion : 항목위치

                // 1) 리스트뷰의 항목(Item)을 클릭할 때마다 한번씩 호출!
                // 2) parent -> 리스트 뷰 통째, view -> 리스트 뷰에 들어있는 각각의 textView 의미
                // postion -> 내가 클릭한 항목의 인덱스. id-> 고유넘버 positon 이랑 값이 같음!

                // 실습해보자!!
                // 내가 선택한 생상을 Toast 메세지로 띄워주세요!~~
                // ex) 다크 그린 선택시 => 배경색을 다크 그린으로 바꿉니다!! 라고 Toast 출력


                // 누른 항목에 따라 색상 코드 값을 바로 보내버리기
                Intent intent = new Intent();

                if (position == 0) { // 다크그린 선택했을때

                    Toast.makeText(getApplicationContext(), "그린색입니다..",
                            Toast.LENGTH_SHORT).show();

                    intent.putExtra("color", "#006400");

                } else if (position == 1) { // 노란색 선택했을때
                    Toast.makeText(getApplicationContext(), "노란색입니다...",
                            Toast.LENGTH_SHORT).show();
                    intent.putExtra("color", "#FFFF00");


                } else if (position == 2) { // 베이지 선택했을때
                    Toast.makeText(getApplicationContext(), "베이지색입니다...",
                            Toast.LENGTH_SHORT).show();

                    intent.putExtra("color", "#F5F5DC");

                }

                setResult(RESULT_OK, intent); //RESULT_OK 상수값 -1
                finish();

//                if(position==0){
//                    setResult(RESULT_OK, new Intent().putExtra("color","#F5F5DC"));
//                }





                // 내가 클릭한 그 택스트 뷰의 글자를 바로 토스트로 출력
//                    Toast.makeText(getApplicationContext(), ((TextView)view).getText(),
//                          //  (TextView) view.getText() 뷰.getText 한걸로 택스트 뷰로 바꾸겠다!
//                            Toast.LENGTH_SHORT).show();


//                if(((TextView)view).getText().equals("그레이")){
//                    Toast.makeText(getApplicationContext(), "그레이  ",
//                            Toast.LENGTH_SHORT).show();
//                }else if(((TextView)view).getText().equals("네이비")){
//                    Toast.makeText(getApplicationContext(), "네이비  ",
//                            Toast.LENGTH_SHORT).show();
//                }else if(((TextView)view).getText().equals("베이지")){
//                    Toast.makeText(getApplicationContext(), "베이지  ",
//                            Toast.LENGTH_SHORT).show();
//                }


            }
        });
        //listview.setOnItemLongClickListener(); 길게


    }
}