package com.sample.spring.bean;

public class Printer1A implements Printer1 {

    @Override
    public void print(String message) {
        System.out.println("Printer A : " + message);
    }
}
