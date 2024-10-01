package com.sample.spring.bean2;

import org.springframework.stereotype.Component;

@Component("printerA") // 빈으로 등록됨
// 빈으로 등록하는 방법 -> @Component/ @Controller 이런거 써주면 등록됨

public class PrinterA implements Printer {

    @Override
    public void print(String message) {
        System.out.println("Printer A : " + message);
    }
}
