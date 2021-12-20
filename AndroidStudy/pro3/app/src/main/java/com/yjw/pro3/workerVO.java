package com.yjw.pro3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class workerVO extends BaseAdapter {

    private LayoutInflater inflater; // 추출한 inflater를 저장할 변수
    private Context context; // inflater를 추출하기 위한 화면정보
    private int layout;
    private ArrayList<worker>data;

    private TextView tv0;
    private TextView tv1;

    public workerVO(Context context, int layout, ArrayList<worker> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){ // 이전에 inflate 된 항목 view 가 없다면
            convertView = inflater.inflate(layout,parent,false);
        }

        tv0 = convertView.findViewById(R.id.tv0);
        tv1 = convertView.findViewById(R.id.tv1);

        tv0.setText(data.get(position).getCheck());
        tv1.setText(data.get(position).getTime());

        return convertView;
    }
}
