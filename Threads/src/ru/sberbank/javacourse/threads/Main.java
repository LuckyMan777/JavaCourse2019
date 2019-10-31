package ru.sberbank.javacourse.threads;

public class Main {
    public static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(getTask(1));
        Thread thread2 = new Thread(getTask(2));
        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(counter);
        System.out.println("End");
    }

    private static Runnable getTask(int i2) {
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; ++i) {
                    increment();
                }
            }
        };
    }

    private static void increment() {
        ++counter;
        System.out.println(Thread.currentThread().getName());
    }


}
