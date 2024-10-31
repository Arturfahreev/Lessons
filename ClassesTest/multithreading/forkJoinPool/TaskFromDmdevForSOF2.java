package multithreading.forkJoinPool;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class TaskFromDmdevForSOF2 {
    private static Set<Thread> hashSet = ConcurrentHashMap.newKeySet();

    private static int[] values;

    public static void main(String[] args) throws InterruptedException {
        values = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(300) + 1;
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        MyRecursiveTaskFJP myRecursiveTask = new MyRecursiveTaskFJP(0, values.length);
        Integer max = forkJoinPool.invoke(myRecursiveTask);
        System.out.println(max);
        int size = 0;
        for (Thread thread : hashSet) {
            System.out.println(thread.getName());
            size++;
        }
        System.out.println("HashSet.size: " + hashSet.size());
        System.out.println("Real size: " + size);
        System.out.println();

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.MINUTES);

    }

    public static class MyRecursiveTaskFJP extends RecursiveTask<Integer> {
        int from;
        int to;

        public MyRecursiveTaskFJP(int from, int to) {
            this.from = from;
            this.to = to;
        }
        @Override
        protected Integer compute() {
            if ((to - from) <= (values.length / 10)) {
                hashSet.add(Thread.currentThread());
                int max = Integer.MIN_VALUE;
                for (int i = from; i < to ; i++) {
                    if (values[i] > max) {
                        max = values[i];
                    }
                }
                return max;
            }
            int middle = ((to - from) / 2) + from;
            MyRecursiveTaskFJP task1 = new MyRecursiveTaskFJP(from, middle);
            MyRecursiveTaskFJP task2 = new MyRecursiveTaskFJP(middle, to);
            task2.fork();
            task1.fork();
            return Integer.max(task1.join(), task2.join());
        }
    }
}
