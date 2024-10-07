package com.sample.spring.dao;

import com.sample.spring.dto.SimpleBbsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ISimpleBbsDao {
    public List<SimpleBbsDto> listDao();
    public int countDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(String writer,String title, String content);
    public int delete(@Param("_id") String id);   //delete?id=1
}

// @Mapper -> mybatis annotation
// 원래는 구현체로 구현
// 자바 코드 자체에서는 인터페이스로만 둔것임
// 실제 구현체 -> mybatis통해서 xml 파일에 쓴 것

// DAO = REPOSITORY DB와 관련된 연산을 어떻게 해줄것이냐의 관점
// crud 객체지향코드와 데이터베이스가 혼합지어주는 지점 !!!  db와의 접근 !!
// sql -> db에 반영