package com.sample.spring.bean;

public class Member1 {
    private String name;
    private String nickname;
    private Printer1 printer1;

    public Member1() {

    }
    public Member1(String name, String nickname, Printer1 printer1) {
        this.name = name;
        this.nickname = nickname;
        this.printer1 = printer1;
    }

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Printer1 getPrinter() {
        return printer1;
    }

    public void setPrinter(Printer1 printer1) {
        this.printer1 = printer1;
    }

    public void print() {
        printer1.print("hello" + name + " : " + nickname);
    }
}
