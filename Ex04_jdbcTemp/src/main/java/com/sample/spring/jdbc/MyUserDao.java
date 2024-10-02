package com.sample.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyUserDao { //data access object

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MyUserDto> list() {
        String query = "select * from myuser";
        List<MyUserDto> list = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(MyUserDto.class));
        // Dto는 그냥 갖다 쓰는 애

        return list;
    }

}
