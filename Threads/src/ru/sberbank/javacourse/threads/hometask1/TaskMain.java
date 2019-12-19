package ru.sberbank.javacourse.threads.hometask1;

public class TaskMain {

    public static void main(String[] args) {
        Task<String> t = new Task<>(() -> {
            Thread.sleep(3000);
            //throw new Exception("Exception in thread " + Thread.currentThread().getId());
            return "some result of computing";
        });

        for (int i = 0; i < 5000; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run thread " + Thread.currentThread().getName() + "...");
                    String result = null;
                    try {
                        result = t.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("    in thread " + Thread.currentThread().getName() + " result = " + result);
                }
            }).start();
        }
    }
}
