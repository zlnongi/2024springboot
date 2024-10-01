package com.sample.spring.bean;

public class Printer1B implements Printer1 {

    @Override
    public void print(String message) {
        System.out.println("Printer B : " + message);
    }
}
