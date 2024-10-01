package com.sample.spring.tv1;

public class SamsungTv {
    public SamsungTv() { // 메소드 하나 생성
        System.out.println("===> SamsungTv");
    }
    public void turnOn() { // void는 return값이 없다
        System.out.println("Samsung 전원 on");
    }
    public void turnOff() { // void는 return값이 없다
        System.out.println("Samsung 전원 off");
    }
    public void soundOn() { // void는 return값이 없다
        System.out.println("소리 on");
    }
    public void soundOff() { // void는 return값이 없다
        System.out.println("소리 off");
    }

}
