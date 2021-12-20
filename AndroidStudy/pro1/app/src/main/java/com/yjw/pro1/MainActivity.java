package com.yjw.pro1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private TextView tv1;
    private JSONObject obj;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        tv1=findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(MainActivity.this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                    try {
                        //data를 json으로 변환
                        JSONObject obj = new JSONObject(result.getContents());
                        tv1.setText(obj.getString("userNumber"));
                        a = obj.getString("userNumber");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("a",a);
                    startActivity(intent);

                }
            });
}


