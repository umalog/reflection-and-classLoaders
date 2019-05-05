package com.company.reflection.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)// .SOURCE-видна на уровне компилятора; .CLASS-видна загрузчику класса, нет в runtime
public @interface HumanAnnotation {
    String name();
}
