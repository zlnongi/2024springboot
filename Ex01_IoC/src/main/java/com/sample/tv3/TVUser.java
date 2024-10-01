package com.sample.tv3;

public class TVUser {
    public static void main(String[] args) {
       // LgTv tv = new LgTv();
    //    SamsungTv tv = new SamsungTv();
      //  Tv tv = new SamsungTv(); << 이렇게도 가능함

        BeanContainer container = new BeanContainer();
        Tv tv1 = (Tv) container.getBean(args[0]);

        tv1.turnOn();
        tv1.turnOff();
        tv1.soundOn();
        tv1.soundOff();

    }
}
