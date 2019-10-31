package ru.sberbank.javacourse.threads;

public class Example2 {
    private final Semaphore semaphore = new Semaphore(5);
    private final  Barrier barrier = new Barrier(100);

    public static void main(String[] args) {
        Example2 main = new Example2();

        for (int i = 0; i < 20; ++i){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    main.run();
                }
            }).start();
        }
    }

    public void run() {
        semaphore.lock();

        //System.out.println("before barrier");
        //barrier.await();
        //System.out.println("after barrier");


        try {
            doRun();
        } finally {
            semaphore.unlock();
        }
    }

    private void doRun() {
        System.out.println("    thread id in semaphore = " + Thread.currentThread().getId());
    }
}

