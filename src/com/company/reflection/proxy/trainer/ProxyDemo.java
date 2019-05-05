package com.company.reflection.proxy.trainer;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Trainer trainer = new TrainerImpl();
        trainer.eat("курицу");
        trainer.talk();
        trainer.teach();


        System.out.println("Создание супер-тренера:");
        ClassLoader classLoader = ProxyDemo.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{Trainer.class};
        TrainerMan invocationHandler = new TrainerMan(trainer);

        Trainer man = (Trainer) Proxy.newProxyInstance(
                classLoader,
                interfaces,
                invocationHandler
        );
        System.out.println("Съедено: " + man.eat("грушу"));
        System.out.println("Сказано: " + man.talk());
        man.teach();
    }
}
