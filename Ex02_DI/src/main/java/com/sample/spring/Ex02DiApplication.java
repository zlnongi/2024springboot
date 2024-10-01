package com.sample.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex02DiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex02DiApplication.class, args);

        // ApplicationContext container 생성 -> Config.class를 등록한다
        // 스프링 MVC 형태
        //ApplicationContext context = new AnnotationConfigApplicationContext((Config.class));


    //    Member member1 = (Member) context.getBean("member1");
    //    member1.print();

     //   Member member2 = context.getBean("Hello,", Member.class);
    }

}
