package com.sample.spring.tv2;

public class TVUser {
    public static void main(String[] args) {
       // LgTv tv = new LgTv();
        SamsungTv tv = new SamsungTv();
      //  Tv tv = new SamsungTv(); << 이렇게도 가능함

        tv.turnOn();
        tv.turnOff();
        tv.soundOn();
        tv.soundOff();

    }
}
