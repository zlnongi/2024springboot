package com.sample.spring.jdbc;

import lombok.Data;

@Data
public class MyUserDto { // Data transfer object 데이터를 이곳저곳에 전달/전송해서 쓰기편하게 묶어놓은 덩어리
    String id;
    String name;
}
