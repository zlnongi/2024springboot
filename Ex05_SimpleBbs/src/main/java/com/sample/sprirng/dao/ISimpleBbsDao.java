package com.sample.sprirng.dao;

import java.util.List;

import com.sample.sprirng.dto.SimpleBbsDto;

public interface ISimpleBbsDao {
    public List<SimpleBbsDto> listDao(); // 메소드
    // 어떤 기능(메소드)을 가져야하는지 명시하는 역할
    // 실제 기능은 내용은 인터페이스가 아니라 구현 클래스(SimpleBbsDao)에서 작성

    public Integer countDao(); // 얘도 메소드
    // int를 사용하면 null값을 반환해주지 않음 따라서 Integer을 사용하는 것

    public SimpleBbsDto viewDao(String id); // viewDao에 id값을 넣어서 view를 각각 보여줘야함
    // SimpleBbsDto에서 사용하는 것들 기준으로 여기서도 사용하겠다는 뜻

    public int writeDao(String writer, String title, String content); // data가 들어갔느냐 안 들어갔냐?
    // 함수 안에 매개변수를 꽂아넣어야함
    // int를 쓴다는건 0과 1이 나온다는 것

    public int delete(String id); // delete?id=1
    // id값을 받아서 delete함
}
