package ru.sberbank.javacourse.threads.classtask1;

public class Example {
    static volatile boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {
        Example example = new Example();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.run();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.finish();
            }
        });
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public void run() {
        int x = 0;
        while (keepRunning)
            ++x;
        System.out.println(x);
    }

    public void finish() {
        keepRunning = false;
    }

}
