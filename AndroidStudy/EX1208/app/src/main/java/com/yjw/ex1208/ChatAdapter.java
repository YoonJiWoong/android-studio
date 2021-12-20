package com.yjw.ex1208;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {

    // Adapter 의 역할!
    // - 템플릿의 주소를 가지고 눈에 보이게 만든다. (xml=> view객체) => inflate
    //      ex) findViewById, setContentView => 대표적인 inflate 작업!
    // ============================== inflate는 엑티비티밖에 못해
    // - ArrayList<ChatVO>에 저장되어 있는 데이터로 View로 바뀐 템플릿을 꾸민다!
    // - listView 에 추가한다.
    // ============================== 항목당 한번씩 일어나는 일!!!

    // Adapter가 필요로 하는 정보 !!!
    // 1) Inflater 를 추출할 Context 정보
    // 2) 템플릿의 ID
    // 3) 꾸밀 데이터 (ArrayList)

    private LayoutInflater inflater; // 추출한 inflater를 저장할 변수
    private Context context; // inflater를 추출하기 위한 화면정보
    private int layout; // 템플릿 id
    private ArrayList<ChatVO> data; // 꾸밀 데이터

    private TextView tv_id;
    private TextView tv_msg;



    // context, layout, data 만 생성자 매개변수로 만들기!!
    public ChatAdapter(Context context, int layout, ArrayList<ChatVO> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;

        // context에서 LayoutInflater 추출
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() { // 리스트 뷰 항목 개수
        return data.size();
    }

    @Override
    public Object getItem(int position) { // position 번째의 아이템을 리턴!
        return data.get(position);
    }

    @Override
    public long getItemId(int position) { //
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //  position 항목수, convertView 전에 했던거,
        // convertView가 null 이라면 inplate 해준다!

        //  return data.size(); 에 적어준 횟수만큼 호출된다!
        // ============================== 항목당 한번씩 일어나는 일!!!
        // - ArrayList<ChatVO>에 저장되어 있는 데이터로 View로 바뀐 템플릿을 꾸민다!
        // - listView 에 추가한다.

        if(convertView==null){ // 이전에 inflate 된 항목 view 가 없다면
            convertView = inflater.inflate(layout,parent,false);
        }

        // 아직 안꾸몄어요~~

        // 템플릿을 view 로 만들어서 저장해둔 객체인 convertView 안에서 찾겠다.
        // 템플릿에서 찾겠다.

        ImageView img = convertView.findViewById(R.id.img);
        TextView tv_id = convertView.findViewById(R.id.tv_id);
        TextView tv_msg = convertView.findViewById(R.id.tv_msg);

        img.setImageResource(data.get(position).getImgID());
        tv_id.setText(data.get(position).getName());
        tv_msg.setText(data.get(position).getMsg());



        return convertView;
    }

}
