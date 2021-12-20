package com.yjw.ex1211;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Fragment3 extends Fragment {

    // Time 표현하는 TextView 찾기
    TextView tv_time;
    ImageView[] dodos = new ImageView[9];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_3, container, false);

        tv_time=v.findViewById(R.id.tv_1);

        // 밑에 만든 class TimeThread는 Thrad가 해야할 일에 대해 설계만 한거임~~
        // 메모리할당(객체생성)후 start 시켜야 함
        TimeThread thread = new TimeThread(10);
        thread.start(); // Thread 동작할 모든 준비를 마친 뒤 run

        for(int i =0; i<dodos.length; i++){
            int imgID = getResources().getIdentifier("imageView"+(i+1),"id",
                    getActivity().getPackageName());
            // 엑티비티에서 바로 하면 getActivity는 안붙이고 바로 getPackageName을 붙여



            dodos[i] = v.findViewById(imgID);
            dodos[i].setImageResource(R.drawable.off);
            dodos[i].setTag("0");



            new DoThread(dodos[i]).start();

            dodos[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 두더지를 클릭했을때
                    if(v.getTag().toString().equals("1")){
                        Toast.makeText(getContext(),"잡았다 요놈!",Toast.LENGTH_SHORT).show();
                    }


                }
            });

        }

        return v;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            // Thread에서 해당 handler 한테 Message 보내면
            // 그거 처리하는 곳
            tv_time.setText(msg.arg1+"");


        }
    };


    // 시간을 관리하는 Tread 클래스 설계

    public class TimeThread extends  Thread{ // Tread 상속
        // extends Thread 했기 때문에~ 지금부터 Thread!!

        private int start; // 해당 Thread가 몇초부터 시작할 건지 전달받을 거임!

        public TimeThread(int start) {
            this.start = start;
        }
        // Thread가 시작하면 실행되는 메소드
        // run은 딱 한번만 실행됨!
        @Override
        public void run() {
            // 30부터 0까지 1씩 감소해야함!
            // 뭐 써야할까...? for문!!
            for(int i=start; i>=0; i-- ){
              //  tv_time.setText(i+"");
                // Thread 쉬게 하는법~~
                // Thread는 화면 컨트롤을 할 수 없다

                //우리가 새로 만든 TimeThread는 setText(UI 업데이트) 못함 => 중지됨!
                // UI업데이트 작업은 MainThread로 전달해서 처리하게 해줘야함~
                // 전달해주는 객체 -> Handler!!

                // 전달할땐 행동을 전송할 순 없음!
                // 데이터만 보낼 수 있음!!!
                // Message 라는 객체에 담아서 보내줘야함! => 원리는 vo랑 비슷~
                // => int arg1, int arg2, Object obj;

                Message msg = new Message();
                msg.arg1 = i;
                // handler에 값 전달~~
                handler.sendMessage(msg);



                try {
                    Thread.sleep(1000); // 1초는 1000
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


        }
    }

    Handler dHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            /////???


            ImageView dodo = (ImageView) msg.obj;
            dodo.setImageResource(msg.arg1);
            dodo.setTag(msg.arg2+"");

        }
    };


    public class DoThread extends Thread{

        private ImageView img; // 해당 Thread의 담당 두더지~~

       public DoThread(ImageView img){

           this.img = img;

        }

        @Override
        public void run() {

           while (true){ // 두더지는 무한으로 왔다갔다 할것이니! 무한 반복 사용하기~
                int offTime = new Random().nextInt(5000)+500;
                // 0.5 ~ 5.5초 사이의 랜덤 수 뽑기!!

               try {
                   Thread.sleep(offTime);

                   // on 이미지로 바꿀껀데! 서브 Thread 에서는 이미지를 바꿀 수 없음....
                   // Handler 한테 Message 보내서 바꿔달라 요청해야함!
                    Message msg = new Message();
                    msg.obj = img; // 담당 두더지!
                    msg.arg1 = R.drawable.on;
                    msg.arg2 = 1;


                    dHandler.sendMessage(msg);

                    // 올라온 상태로 쉽시다.!
                   int onTime = new Random().nextInt(1000)+500;
                   // 0.5 ~ 1.5로 사이로 쉼~~

                   Thread.sleep(onTime);

                   Message msg2 = new Message();
                   msg2.obj = img;
                   msg2.arg1 = R.drawable.off;
                   msg2.arg2 = 0;
                   dHandler.handleMessage(msg2);




               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }

        }
    }

}