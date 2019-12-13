package ru.sberbank.javacourse.threads.hometask1;

import java.util.concurrent.Callable;

public class Task<T> {
    private final Object lock = new Object();
    private T result;
    private Callable<? extends T> callable;
    private RuntimeException exceptionOnComputingCallable;
    private volatile boolean resultIsComputed = false;
    private volatile boolean resultIsComputing = false;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws InterruptedException {
        if (resultIsComputed) {
            return result;
        }
        if (resultIsComputing) {
            synchronized (lock) {
                lock.wait();
            }
        } else {
            resultIsComputing = true;
            try {
                result = callable.call();
                resultIsComputed = true;
                synchronized (lock) {
                    lock.notifyAll();
                }
                return result;
            } catch (Exception e) {
                exceptionOnComputingCallable = new RuntimeException("Exception on computing callable", e);
            }
        }
        if (exceptionOnComputingCallable != null) {
            throw exceptionOnComputingCallable;
        }
        return result;
    }
}