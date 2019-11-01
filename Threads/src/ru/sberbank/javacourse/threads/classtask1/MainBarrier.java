package ru.sberbank.javacourse.threads.classtask1;

public class MainBarrier {
    private final Barrier barrier = new Barrier(20);

    public static void main(String[] args) {
        MainBarrier main = new MainBarrier();

        for (int i = 0; i < 20; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        main.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void run() throws InterruptedException {
        System.out.println("before barrier");
        barrier.await();
        System.out.println("after barrier");
    }
}

