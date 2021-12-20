package com.yjw.ex1201_1;

import java.util.ArrayList;

public class ChatVO {
    // 1. VO에 담고 싶은 변수를 정의한다. => private
    // 2. 객체를 생성할 때 변수에 값을 넣어줄 수 있는 생성자 만든다.
    // 3. getter

    // 방금 설계한 ChatVO 형태의 객체를 담을 수 있는 ArrayList

    private int imgID;
    private String name;
    private String msg;

    // alt + insert 눌러서 자동완성

    // 2. 객체를 생성할때 변수에 값을 넣어 줄 수 있는 생성자를 만든다.
    // 객체를 생성할 떄 반드시 값을 지정해줘야해!
    // 객체 생성(메모리 할당) 할 떄 한번 호출되는 메소드를 사용하자!
    // 메소드의 이름이 클래스의 이름과 같고, 리턴타입 명시 x


    public ChatVO() {
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ChatVO(int imgID, String name, String msg) {
        this.imgID = imgID;
        this.name = name;
        this.msg = msg;
    }

    public int getImgID() {
        return imgID;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }
}
