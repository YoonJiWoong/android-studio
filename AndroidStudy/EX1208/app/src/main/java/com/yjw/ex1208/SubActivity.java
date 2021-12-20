package com.yjw.ex1208;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    private Button btn1;
    private ListView listView;
    private EditText edt_msg;
    ArrayList<ChatVO> data = new ArrayList<ChatVO>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        Intent intent = getIntent();
        String et1 = intent.getStringExtra("et1");
        String et2 = intent.getStringExtra("et2");

        edt_msg = findViewById(R.id.edt_msg);


        btn1=findViewById(R.id.btn_send);
        listView=findViewById(R.id.listview);
        edt_msg=findViewById(R.id.edt_msg);

        ChatAdapter chatAdapter = new ChatAdapter(getApplicationContext(),R.layout.borad,data);
        // 컨택스트, 디자인한 xml, data
        listView.setAdapter(chatAdapter);

        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = edt_msg.getText().toString();
                if(!a.equals("")){



                    data.add(new ChatVO(R.drawable.profi,et1,edt_msg.getText().toString()));


                    chatAdapter.notifyDataSetChanged();

                }
                else{
                    manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                }





            }
        });



    }
}