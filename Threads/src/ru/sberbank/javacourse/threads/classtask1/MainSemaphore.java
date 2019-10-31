package ru.sberbank.javacourse.threads.classtask1;

public class MainSemaphore {
    private final Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        MainSemaphore main = new MainSemaphore();

        for (int i = 0; i < 20; ++i) {
            new Thread(main::run).start();
        }
    }

    private void run() {
        semaphore.lock();
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
