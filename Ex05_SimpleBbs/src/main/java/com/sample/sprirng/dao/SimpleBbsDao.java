package com.sample.sprirng.dao;

import com.sample.sprirng.dto.SimpleBbsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao { // 얘는 부모에서 추상화돼서 만들어진거임
    @Autowired
    JdbcTemplate template; // 누가 데려왔는지??

    @Override
    public List<SimpleBbsDto> listDao(){
        System.out.println("listDao()");
        String query = "select * from simple_bbs order by id desc";
        List<SimpleBbsDto> dtos = template.query(query, new BeanPropertyRowMapper<>(SimpleBbsDto.class));
                // BeanPropertyRowMapper는 SimpleBbsDto의 형을 바꿔줌
        return dtos;
    }

    @Override
    public Integer countDao() { // object data로 들어옴
        System.out.println("countDao()");
        String query = "select count(*) from simple_bbs"; // 몇개를 count하겟냐?
        Integer count = template.queryForObject(query, Integer.class); // object data 값이 들어오기 때문에 queryForObject 사용

        return count;
    }

    @Override
    public SimpleBbsDto viewDao(String id) {
        System.out.println("viewDao()");
        String query ="select * from simple_bbs where id= " +id;
        SimpleBbsDto dto = template.queryForObject(query, new BeanPropertyRowMapper<>(SimpleBbsDto.class));
        return dto;
    }

    @Override // override는 왜 써야하는건지 공부를 잘해야함!! 부모클래스의 메서드를 자식메서드에서 다시 재정의하는 것임
    public int writeDao(String writer, String title, String content) {
        System.out.println("writeDao()");
        String query = "insert into simple_bbs(writer, title, content) values(?,?,?)"; // ? ? ? 써주면 알아서 wrtier, title, content 넣어줌
        int dtoup = template.update(query,writer,title,content); // () 안에 있는 것들이 쿼리문의 ? 물음표로 간다고 생각
        // 최종값은 int로 받아들임

        return dtoup;
    }

    @Override
    public int delete(String id) {
        System.out.println("delete()");
        String query = "delete from simple_bbs where id= ?";
        int dtodel = template.update(query,Integer.parseInt(id)); // null값이 올 수도 있으므르 Integer로 바꿔줌 (문자로 들어오는 것을 숫자로 바꿔준거임)
        return dtodel;
    }


}
// interface는 추상화