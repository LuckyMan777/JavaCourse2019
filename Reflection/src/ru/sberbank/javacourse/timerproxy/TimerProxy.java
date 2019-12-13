package ru.sberbank.javacourse.timerproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerProxy implements InvocationHandler {
    private final Object delegate;

    public TimerProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long m = System.currentTimeMillis();
        Object result = method.invoke(delegate, args);
        double time = System.currentTimeMillis() - m;
        System.out.println(String.format("Time = %s", time));
        return result;
    }
}
