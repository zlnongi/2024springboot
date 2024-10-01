package com.sample.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex02DiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex02DiApplication.class, args);

        // container 생성
        //ApplicationContext context = new AnnotationConfigApplicationContext((Config.class));


    //    Member member1 = (Member) context.getBean("member1");
    //    member1.print();

     //   Member member2 = context.getBean("Hello,", Member.class);
    }

}
