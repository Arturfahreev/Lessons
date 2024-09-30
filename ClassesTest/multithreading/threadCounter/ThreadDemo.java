package multithreading.threadCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Long> listTime = new ArrayList<>();
        Counter counter = new Counter();
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            executorService.execute(new CounterThread(counter));
            executorService.execute(new CounterThread(counter));
            executorService.execute(new CounterThread(counter));
            executorService.execute(new CounterThread(counter));
            long end = System.currentTimeMillis();
            listTime.add(end - start);
            counter.setCount(0);
        }

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
        long sum = 0;
        for (int i = 0; i < listTime.size(); i++) {
            sum += listTime.get(i);
        }
        double average = sum / listTime.size();
        System.out.println("Time average " + average);

    }
}

