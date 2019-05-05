package com.company.reflection.proxy.anotherExample;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AopExample implements InvocationHandler {

    private FileParser fileParser;

    public AopExample(FileParser fileParser) {
        this.fileParser = fileParser;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        List<Class<? extends Annotation>> annotations = Arrays
                .stream(method.getAnnotations())
                .map(Annotation::annotationType)
                .collect(Collectors.toList());

        if (annotations.contains(WithArgs.class)) { // мониторим аргументы там где надо
            System.out.println(Arrays.toString(args));
        }

        long startTime = System.currentTimeMillis();
        try {
            o = method.invoke(fileParser, args);
        } catch (Exception e) {
            System.out.println("отчитаемся об ошибке: " + e.getMessage()); //а вдуг пригодиться)
            throw e;
        } finally {
            long stopTime = System.currentTimeMillis(); // мониторим время работы
            System.out.println("Время работы метода " + method.getName() + " = " + (stopTime - startTime));
        }

        if (annotations.contains(WithReturnValue.class)) { // мониторим позвращаемое значение где требуется
            System.out.println(o);
        }
        return o;
    }
}
