package com.company.reflection.entity;

@HumanAnnotation(name = "Строитель")
public class Human {
    private static String type = "Гуманоид";
    private final int money = 100;
    private String name = "Вася";


    @Override
    public String toString() {
        return "Human{name='" + name +
                "', money=" + money +
                "}, type = " + type;
    }
}
