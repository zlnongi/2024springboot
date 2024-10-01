package com.sample.spring.bean2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 얘가 아마 스프링부트.. 빈으로 등록이됨
// 컨트롤러의 역할 : 디스패처 서블릿 동적으로 html을 만들어줘서 컨트롤러에게 실행하라고 알려줌
// 클라이언트가 보냇을 때의 진입점

public class MyController {
    @Autowired
    Member member1;

    @Autowired
    Member member2;

    @Autowired
    @Qualifier("printerB")
    Printer printer;

    @RequestMapping("/")
    public @ResponseBody String root() {
        member1.print();
        member1.setPrinter(printer);
        member1.setName("여진홍");
        member1.setNickname("학생");
        member1.print();

        return "annotation!!!!!!!" + member1.print();
    }


}
