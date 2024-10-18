package multithreading.forkJoinPool;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class MainForkJoinPool {
    public static Set<Thread> setThread = new HashSet<>();
    public static int[] array = new int[100_000_000];
    private static Map<Integer, String> loadFactor = new TreeMap<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int part = Runtime.getRuntime().availableProcessors();

        createArray();

        ForkJoinPool forkJoinPool;
        forkJoinPool = new ForkJoinPool(10);
        MyRecursiveTask myRecursiveTask;

        for (int i = 10; i < 100_000_000; i *= 10) {
            //part = (Runtime.getRuntime().availableProcessors()) * i;
            //int threshold = array.length / part ;
            //System.out.printf("Part: %d Threshold: %,d%n", part, threshold);
            System.out.printf("Threshold = %,d%n", i);
            long start = System.currentTimeMillis();
            myRecursiveTask = new MyRecursiveTask(0, array.length, i);
            Long result = forkJoinPool.invoke(myRecursiveTask);
            System.out.println(forkJoinPool.getParallelism() + " " + forkJoinPool.getPoolSize() + " " + forkJoinPool.getQueuedSubmissionCount());
            long end = System.currentTimeMillis();
            loadFactor.put(i, String.valueOf((end - start) + " Threads: " + setThread.size()));

            //System.out.printf("Time: %,d%n", (end - start));
            //System.out.printf("Sum: %,d%n", result);
            //System.out.println("Number of threads: " + setThread.size());
            //setThread.forEach(thread -> System.out.println(thread.getName()));
            setThread.clear();

        }
        for (var entry : loadFactor.entrySet()) {
            System.out.printf("Threshold %-10d Time - %-10s%n", entry.getKey(), entry.getValue());
        }
    }

    private static void createArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    static class MyRecursiveTask extends RecursiveTask<Long> {
        int from;
        int to;
        int part;

        public MyRecursiveTask(int from, int to, int part) {
            this.from = from;
            this.to = to;
            this.part = part;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= part) {
                MainForkJoinPool.setThread.add(Thread.currentThread());
                //long sum = 0L;
                AtomicLong sum = new AtomicLong(0);
                for (int i = from; i < to; i++) {
                    sum.addAndGet(array[i]);
                    //sum += array[i];
                }
                return sum.get();
                //return sum;
            }
            MyRecursiveTask task1 = new MyRecursiveTask(from, ((to - from) / 2) + from, part);
            MyRecursiveTask task2 = new MyRecursiveTask(((to - from) / 2) + from, to, part);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
