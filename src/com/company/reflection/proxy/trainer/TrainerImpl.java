package com.company.reflection.proxy.trainer;

public class TrainerImpl implements Trainer {
    @Override
    public int eat(String something) {
        System.out.println("ем " + something);
        return 1;
    }

    @Override
    public String talk() {
        System.out.println("говорю");
        return "Говорю";
    }

    @Override
    public void teach() {
        System.out.println("учу");
    }
}
