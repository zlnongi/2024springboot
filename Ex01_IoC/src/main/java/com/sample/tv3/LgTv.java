package com.sample.tv3;

public class LgTv implements Tv {
    public LgTv() { // 메소드 하나 생성
        System.out.println("===> LgTv");
    }

    @Override
    public void turnOn() { // void는 return값이 없다
        System.out.println("Lg 전원 on");
    }

    @Override
    public void turnOff() { // void는 return값이 없다
        System.out.println("Lg 전원 off");
    }

    @Override
    public void soundOn() { // void는 return값이 없다
        System.out.println("Lg 소리 on");
    }

    @Override
    public void soundOff() { // void는 return값이 없다
        System.out.println("Lg 소리 off");
    }

}
