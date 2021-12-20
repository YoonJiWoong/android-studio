package com.yjw.ex1123_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String text1 = et1.getText().toString();
                String text2 = et2.getText().toString();
                String text3 = et3.getText().toString();
                String text4 = et4.getText().toString();
                String text5 = et5.getText().toString();
                String text6 = et6.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("input1",text1);
                intent.putExtra("input2",text2);
                intent.putExtra("input3",text3);
                intent.putExtra("input4",text4);
                intent.putExtra("input5",text5);
                intent.putExtra("input6",text6);

                startActivity(intent);
            }
        });


    }
}