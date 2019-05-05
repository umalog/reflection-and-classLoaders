package com.company.reflection.proxy.anotherExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MockExample implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Заглушки:
        if (method.getName().equals("copy")) {
            return true;
        }
        return null;
    }
}
