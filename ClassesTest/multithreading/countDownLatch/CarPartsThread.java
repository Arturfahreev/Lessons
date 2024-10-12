package multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CarPartsThread implements Runnable {
    CountDownLatch countDownLatch;
    CarParts carPart;

    public CarPartsThread(CountDownLatch countDownLatch, CarParts carPart) {
        this.countDownLatch = countDownLatch;
        this.carPart = carPart;
    }


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " " + carPart + " is preparing...");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + " " + carPart + " is ready!");
            countDownLatch.countDown();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
