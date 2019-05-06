package com.company.reflection.proxy.anotherExample;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = FileParser.class.getClassLoader();
        Class<?>[] interfaces = FileParser.class.getInterfaces();
        InvocationHandler invocationHandler = new AopExample(new FileParser());

        Parser fileser = (Parser) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        fileser.read();
        fileser.copy(Paths.get("tmp.txt"));


        Parser mockParser = (Parser) Proxy.newProxyInstance(classLoader, interfaces, new MockExample());
        mockParser.read();
        Path path = Paths.get("tmp.txt");
        mockParser.copy(path);

    }
}
