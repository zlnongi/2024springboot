package com.sample.spring.bean2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // 빈 등록이 가능해짐
@Component ("configBean2")
public class Config {

    @Bean
    public Member member1() {

        Member member1 = new Member();
        member1.setName("홍길동");
        member1.setNickname("도사");
        member1.setPrinter(new PrinterA());
        return member1;
    }

    @Bean
    public Member member2() {
        return new Member("이순신", "장군", new PrinterA());
    }
}
