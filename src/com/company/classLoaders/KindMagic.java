package com.company.classLoaders;


public class KindMagic implements Magic {
    public KindMagic() {
    }

    public void doMagic() {
//        System.out.println("Абра-кадабра!");
        System.out.println("Абра-кадабра!!! # и активно машет руками...");
    }

    static {
//        System.out.println("Хоттабыч");
        System.out.println("Хоттабыч2.0");
    }
}
