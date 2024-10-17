package multithreading.forkJoinPool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MainForkJoinPool {
    public static Set<Thread> setThread = new HashSet<>();
    public static int[] array = new int[100_000_000];
    public static int part = array.length / (Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) {
        createArray();
        long start = System.currentTimeMillis();
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(0, array.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long result = forkJoinPool.invoke(myRecursiveTask);
        System.out.printf("Time: %,d%n", (System.currentTimeMillis() - start));
        System.out.printf("Sum: %,d%n", result);
        for (Thread thread : setThread) {
            System.out.println(thread.getName());
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

        public MyRecursiveTask(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= MainForkJoinPool.part) {
                MainForkJoinPool.setThread.add(Thread.currentThread());
                long sum = 0L;
                for (int i = from; i < to; i++) {
                    sum += array[i];
                }
                return sum;
            }
            MyRecursiveTask task1 = new MyRecursiveTask(from, ((to - from) / 2) + from);
            MyRecursiveTask task2 = new MyRecursiveTask(((to - from) / 2) + from, to);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
