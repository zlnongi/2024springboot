package com.sample.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 빈 등록이 가능해짐
public class Config1 {

    @Bean
    public Member1 member1() {

        Member1 member1 = new Member1();
        member1.setName("홍길동");
        member1.setNickname("도사");
        member1.setPrinter(new Printer1A());
        return member1;
    }

    @Bean
    public Member1 member2() {
        return new Member1("이순신", "장군", new Printer1A());
    }
}
