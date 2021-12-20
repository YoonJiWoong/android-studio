package com.yjw.ex1211;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;


public class Fragment4 extends Fragment {

    EditText edturl;
    Button btn_seting;
    CheckBox checkBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_4, container, false);

        edturl = v.findViewById(R.id.edturl);
        btn_seting = v.findViewById(R.id.btn_seting);
        checkBox = v.findViewById(R.id.checkBox);



        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);
        // mySPF 라는 이름의 SharedPreference 가져올건데~~
        // 있으면! 있는거 가져오고! 없으면 새로 만들어라!!
//        checkBox.setChecked(spf.getBoolean("check",checkBox.isChecked()));
//        if (checkBox.isChecked()){
//            edturl.setText(spf.getString("url","http://"));
//        }

        if(spf.getBoolean("check",false)){
            edturl.setText(spf.getString("url","https://"));
            checkBox.setChecked(true);
        }


        btn_seting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SharedPreference

                // 업로드 해주는 Preference 안에 Editor 가져오기
                String url = edturl.getText().toString();
                SharedPreferences.Editor edit = spf.edit();

                edit.putString("url",url);

                // checkbox 체크 했으면 체크했다고 spf에 넣어주기
                edit.putBoolean("check",checkBox.isChecked());

                edit.commit(); // ★★★★★★★★!! 중요!~


                Toast.makeText(getContext(),edturl.getText().toString(),Toast.LENGTH_SHORT).show();


            }
        });



        return v;
    }
}