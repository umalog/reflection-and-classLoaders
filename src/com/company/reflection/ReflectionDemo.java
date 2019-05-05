package com.company.reflection;


import com.company.reflection.entity.Human;
import com.company.reflection.entity.HumanAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Human human = new Human();

        /*  Как получить объект типа Class:
         *  Class<Human> aClass = Human.class;
         *  aClass = (Class<Human>) human.getClass();
         *  aClass = (Class<Human>) Class.forName("com.company.reflection.entity.Human");
         */

        System.out.println("Name->" + human.getClass().getName() +
                "  SimpleName->" + human.getClass().getSimpleName() +
                "  CanonicalName->" + human.getClass().getCanonicalName());
        System.out.println();

        printFields(human);
        System.out.println();

        changeFields(human);
        System.out.println();

        readAnnotation(Human.class);

    }

    private static void printFields(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field declaredField : fields) {
            System.out.print(
                    Modifier.toString(declaredField.getModifiers()) + " " +
                            declaredField.getType().getSimpleName() + " " +
                            declaredField.getName() + ": ");
            declaredField.setAccessible(true); // доступ к приватному полю
            System.out.println(declaredField.get(obj));
        }
    }

    private static void changeFields(Object obj) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("OLD " + obj);
        Field type = obj.getClass().getDeclaredField("type");
        type.setAccessible(true);
        type.set(obj, "Пришелец");

        Field money = obj.getClass().getDeclaredField("money");
        money.setAccessible(true);
        money.setInt(obj, 500); // final такой final )))

        Field name = obj.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj, "Коля");
        printFields(obj);
        System.out.println("NEW " + obj);
    }

    private static void readAnnotation(Class aClass) {
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Аннотация " + annotation);
        }
        HumanAnnotation annotation = (HumanAnnotation) aClass.getAnnotation(HumanAnnotation.class);
        if (annotation != null) {
            System.out.println(annotation.name());
        }
    }
}
