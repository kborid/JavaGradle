package com.kborid.jav.锁;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    volatile
    private static Semaphore mSemaphore = new Semaphore(10, true);

    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//            new Thread("thread" + i) {
//                @Override
//                public void run() {
//                    super.run();
//                    semaphoreTest();
//                }
//            }.start();
//        }
        for (int i = 0; i <= Integer.MAX_VALUE + 1; i++) {
            String t = i + "";
        }
    }

    public static void semaphoreTest() {
        try {
            mSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int delay = random.nextInt(4000);
        System.out.println(Thread.currentThread().getName() + "-进来了，需等待" + delay + "s。。 ");

        try {

            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "完成了");

        mSemaphore.release();
    }
}
