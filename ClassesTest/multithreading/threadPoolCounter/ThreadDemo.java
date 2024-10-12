package multithreading.threadPoolCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class ThreadDemo {
    private static List<Long> listTime = new ArrayList<>();
    private static int counts = 10;
    private static int threadsNumber = 20;

    public static void main(String[] args) throws InterruptedException {
        CounterLock counterLock = new CounterLock();
        CounterLock counterLock2 = new CounterLock();
        CounterSynchronized counterSynchronized = new CounterSynchronized();
        CounterSynchronized counterSynchronized2 = new CounterSynchronized();

        threadPoolExecutor(counterLock);
        threadPoolExecutor(counterSynchronized);
        threadStart(counterLock2);
        threadStart(counterSynchronized2);
    }

    private static void threadPoolExecutor(Counter counter) throws InterruptedException {
        for (int i = 0; i < counts; i++) {
            ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);

            long start = System.currentTimeMillis();
            for (int j = 0; j < threadsNumber; j++) {
                executorService.execute(new CounterThread(counter));
            }
            executorService.shutdown();
            executorService.awaitTermination(1000, TimeUnit.SECONDS);
            long end = System.currentTimeMillis();
            listTime.add(end - start);
            System.out.printf(i + " Counter" + " %,d%n", counter.getCount());
        }
        averageTime();
    }

    private static void threadStart(Counter counter) throws InterruptedException {
        for (int i = 0; i < counts; i++) {
            List<Thread> listThread = new ArrayList<>();

            long start = System.currentTimeMillis();
            for (int j = 0; j < threadsNumber; j++) {
                listThread.add(new CounterThread(counter));
            }
            for (Thread thread : listThread) {
                thread.start();
            }
            for (Thread thread : listThread) {
                thread.join();
            }
            long end = System.currentTimeMillis();
            listTime.add(end - start);
            System.out.printf(i + " Counter" + " %,d%n", counter.getCount());
            listThread.clear();
        }
        averageTime();
    }

    private static void averageTime() {
        long sum = 0;
        for (Long time : listTime) {
            sum += time;
        }
        Double average = Double.valueOf (sum / listTime.size());
        System.out.printf("Time average " + average + "\n");
        listTime.clear();
    }
}

