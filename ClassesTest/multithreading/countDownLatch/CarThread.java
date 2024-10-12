package multithreading.countDownLatch;

import javax.swing.table.TableRowSorter;
import java.util.concurrent.CountDownLatch;

public class CarThread implements Runnable {

    CountDownLatch countDownLatch;

    public CarThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Car is preparing to start...");
        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + " Car is ready to start!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
