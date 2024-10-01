package com.sample.spring.tv1;

public class TVUser {
    public static void main(String[] args) {
        LgTv tv = new LgTv();
        SamsungTv tv1 = new SamsungTv();

        tv.powerOn();
        tv.powerOff();
        tv.volumeOn();
        tv.volumeOff();

        tv1.turnOn();
        tv1.turnOff();
        tv1.soundOn();
        tv1.soundOff();

    }
}
