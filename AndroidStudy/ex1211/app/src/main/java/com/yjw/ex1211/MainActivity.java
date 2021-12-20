package com.yjw.ex1211;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bnView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.layout);
        bnView = findViewById(R.id.bnView);

        getSupportFragmentManager().beginTransaction().replace(R.id.layout, new Fragment1()).commit();



        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 내가 클릭한 item(매개변수 MenuItem)의 ID를 검사!

                if(item.getItemId() == R.id.tap1){
                    // 1번 메뉴를 클릭했다면~~~
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout, new Fragment1()).commit();

                }else if(item.getItemId() == R.id.tap2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout, new Fragment2()).commit();

                }else if(item.getItemId() == R.id.tap3){
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout, new Fragment3()).commit();

                }else if(item.getItemId() == R.id.tap4){
                    getSupportFragmentManager().beginTransaction().replace(R.id.layout, new Fragment4()).commit();

                }



                return true;
            }
        });




    }
}