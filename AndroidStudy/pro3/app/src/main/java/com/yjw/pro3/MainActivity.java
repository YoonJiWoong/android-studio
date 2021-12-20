package com.yjw.pro3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ListView listView;
    ArrayList<worker> data = new ArrayList<>();
    private workerVO adapter;


    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    TimeZone time;
    Date date = new Date();
    DateFormat df = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss (z Z)");
    String num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        listView=findViewById(R.id.listview);

        data.add(new worker("출석","12:00"));

         adapter = new workerVO(getApplicationContext(),R.layout.borad,data);

        listView.setAdapter(adapter);

        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                barcodeLauncher.launch(new ScanOptions());

            }
        });


    }


    // Register the launcher and result handler
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();

                } else {


                    try {
                        //data를 json으로 변환
                         JSONObject obj = new JSONObject(result.getContents());
                        num= obj.getString("userNumber");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if(num.equals("1234")){

                        data.add(new worker("출석",getTime().toString()));
                        Toast.makeText(MainActivity.this, "출석체크완료 ", Toast.LENGTH_LONG).show();

                        //   data.add(new ChatVO(R.drawable.img5,"재드래곤",et1.getText().toString()));
                        //   서버에 연동하니깐 지워버려
                        //    2) adapter 새로고침!


                        adapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(MainActivity.this, "QR확인하세요 ", Toast.LENGTH_LONG).show();
                    }






                }
            });

    private String getTime(){
        time = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(time);
        return df.format(date);
    }


}