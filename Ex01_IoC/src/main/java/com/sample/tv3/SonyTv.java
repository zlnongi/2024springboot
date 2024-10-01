package com.sample.tv3;

public class SonyTv implements Tv {
    public SonyTv() { // 메소드 하나 생성
        System.out.println("===> SonyTv");
    }

    @Override
    public void turnOn() { // void는 return값이 없다
        System.out.println("Sony 전원 on");
    }

    @Override
    public void turnOff() { // void는 return값이 없다
        System.out.println("Sony 전원 off");
    }

    @Override
    public void soundOn() { // void는 return값이 없다
        System.out.println("Sony 소리 on");
    }

    @Override
    public void soundOff() { // void는 return값이 없다
        System.out.println("Sony 소리 off");
    }

}
