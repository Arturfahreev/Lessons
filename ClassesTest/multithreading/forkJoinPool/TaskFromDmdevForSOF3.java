package multithreading.forkJoinPool;

import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class TaskFromDmdevForSOF3 {
    private static Set<Thread> hashSet = ConcurrentHashMap.newKeySet();


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] values = new int[100_000];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }

        ExecutorService threadPool = new ForkJoinPool(10);
        Future<Integer> future = findMaxParallel(values, threadPool);

        long start = System.currentTimeMillis();
        int i = 0;
        while (!future.isDone()) {
            i = i + 1;
            System.out.print(i);
            System.out.println(" Calculating...");
        }
        System.out.println("Time " + (System.currentTimeMillis() - start));

        System.out.println("Number: " + future.get());

        System.out.println("Number of threads: " + hashSet.size());
        int size = 0;
        for (Thread thread : hashSet) {
            System.out.println(thread.getName());
            size++;
        }
        System.out.println("Real size: " + size);

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);

    }
    private static Future<Integer> findMaxParallel(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() -> IntStream.of(values)
                .parallel()
                .peek(number -> hashSet.add(Thread.currentThread()))
                .max()
                .orElse(Integer.MIN_VALUE));
    }
}
