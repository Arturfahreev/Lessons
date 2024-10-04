package multithreading.threadCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Long> listTime = new ArrayList<>();
        Counter counter = new Counter();
        //for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            executorService.execute(new CounterThread(counter));
            executorService.execute(new CounterThread(counter));
            executorService.execute(new CounterThread(counter));
            executorService.execute(new CounterThread(counter));
            executorService.shutdown();
            //executorService.awaitTermination(1000, TimeUnit.SECONDS);
            long end = System.currentTimeMillis();
            Thread.sleep(2000L);
            System.out.printf("Counter1 %,d%n ", counter.getCount());
//            executorService.execute(new CounterThread(counter));
//            System.out.println("Counter2 " +counter.getCount());
//            executorService.execute(new CounterThread(counter));
//            System.out.println("Counter3 " +counter.getCount());
//            executorService.execute(new CounterThread(counter));
//            System.out.println("Counter4 " +counter.getCount());

            //listTime.add(end - start);
            //counter.setCount(0);
        //}

//        List<Thread> listThread = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 4; j++) {
//                listThread.add(new CounterThread(counter));
//            }
//            long start = System.currentTimeMillis();
//            for (Thread thread : listThread) {
//                thread.start();
//            }
//            for (Thread thread : listThread) {
//                thread.join();
//            }
//            long end = System.currentTimeMillis();
//            listTime.add(end - start);
//            System.out.println(counter.getCount());
//            listThread.clear();
//            counter.setCount(0);
//        }
//        long sum = 0;
//        for (int i = 0; i < listTime.size(); i++) {
//            sum += listTime.get(i);
//        }
//        double average = sum / listTime.size();
        long time = end - start;
        System.out.printf("Time %,d ", time);

    }
}

