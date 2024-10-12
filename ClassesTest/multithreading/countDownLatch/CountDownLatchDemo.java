package multithreading.countDownLatch;

import java.util.Arrays;
import java.util.concurrent.*;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(CarParts.values().length);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new CarThread(countDownLatch));
        Arrays.stream(CarParts.values())
                .map(part -> new CarPartsThread(countDownLatch, part))
                .forEach(executorService::submit);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

    }
}
