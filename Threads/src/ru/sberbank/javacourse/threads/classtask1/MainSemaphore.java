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
        System.out.println("Try lock by " + Thread.currentThread().getId());
        semaphore.lock();
        try {
            doRun();
        } finally {
            System.out.println("  Unlocked by " + Thread.currentThread().getId());
            semaphore.unlock();
        }
    }

    private void doRun() {
        System.out.println("    thread id in semaphore = " + Thread.currentThread().getId());
    }


}
