package ru.sberbank.javacourse.threads.classtask1;

public class Semaphore {
    private final int maxThreadCount;
    private int currentThreadCount;
    private final Object lock = new Object();

    public Semaphore(int maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
    }

    public void lock(){
        synchronized (lock) {
            System.out.println("Try lock by " + Thread.currentThread().getId());
            ++currentThreadCount;
            if (currentThreadCount >= maxThreadCount){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void unlock(){
        synchronized (lock) {

            --currentThreadCount;
            lock.notify();
            System.out.println("  Unlocked by " + Thread.currentThread().getId());
        }
    }
}
