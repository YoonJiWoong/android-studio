package com.yjw.ex1211;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Fragment2 extends Fragment {

    RadioGroup rg_mincho;
    RadioGroup rg_tang;
    Button btn_result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_2, container, false);

        rg_mincho = v.findViewById(R.id.rg1);
        rg_tang = v.findViewById(R.id.rg2);
        btn_result = v.findViewById(R.id.btn_result);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) { // 클릭했을때 가져와야해서!! v / v2
               RadioButton rb1 = v.findViewById(rg_mincho.getCheckedRadioButtonId());
               RadioButton rb2 = v.findViewById(rg_tang.getCheckedRadioButtonId());


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("당신의 취향은!");
                builder.setMessage(rb1.getText().toString()+"!!"+rb2.getText().toString()+"!!");
                builder.setPositiveButton("끝",null);
                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rb1.setChecked(false);
                        rb2.setChecked(false);
                    }
                });
                builder.create().show();

            }
        });


        return v;

    }
}