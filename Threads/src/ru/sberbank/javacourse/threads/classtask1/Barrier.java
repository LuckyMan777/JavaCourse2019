package ru.sberbank.javacourse.threads.classtask1;

public class Barrier {
    private final int threadCount;
    private int currentThreadCount = 0;
    private final Object lock = new Object();

    public Barrier(int threadCount) {
        this.threadCount = threadCount;
    }

    public void await() {
        synchronized (lock) {
            ++currentThreadCount;
            if (currentThreadCount < threadCount) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                lock.notifyAll();
            }
        }
    }
}
