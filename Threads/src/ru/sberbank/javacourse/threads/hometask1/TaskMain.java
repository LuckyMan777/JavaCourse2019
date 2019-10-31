package ru.sberbank.javacourse.threads.hometask1;

public class TaskMain {

    public static void main(String[] args) {
        Task<String> t = new Task<>(() -> {
            Thread.sleep(3000);
            //throw new Exception("Exception in thread " + Thread.currentThread().getId());
            return "some result of computing";
        });

        for (int i = 0; i < 20; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run thread " + Thread.currentThread().getId() + "...");
                    String result = t.get();
                    System.out.println("    in thread " + Thread.currentThread().getId() + " result = " + result);
                }
            }).start();
        }
    }
}
