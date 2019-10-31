package ru.sberbank.javacourse.threads.hometask1;

import java.util.concurrent.Callable;

public class Task<T> {
    private final Object lock = new Object();
    private T result;
    private Callable<? extends T> callable;
    private RuntimeException exception_on_computing_callable;
    private volatile boolean resultIsComputed = false;
    private volatile boolean resultIsException = false;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        synchronized (lock) {
            if (resultIsComputed) {
                return result;
            }
            if (resultIsException) {
                throw exception_on_computing_callable;
            }
            try {
                result = callable.call();
                resultIsComputed = true;
                lock.notifyAll();
                return result;
            } catch (Exception e) {
                exception_on_computing_callable = new RuntimeException("Exception on computing callable", e);
                resultIsException = true;
            }
        }
        return result;
    }
}
