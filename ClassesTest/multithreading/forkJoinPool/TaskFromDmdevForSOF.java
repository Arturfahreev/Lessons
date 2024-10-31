package multithreading.forkJoinPool;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class TaskFromDmdevForSOF {
    private static Set<Thread> hashSet = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] values = new int[100];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(300) + 1;
        }

        System.setProperty("java.util.concurrent" + ".ForkJoinPool.common" + ".parallelism", "9");

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        int max = findMaxParallel(values, threadPool);
        System.out.println(max);

        int size = 0;
        for (Thread thread : hashSet) {
            System.out.println(thread.getName());
            size++;
        }
        System.out.println("HashSet.size: " + hashSet.size());
        System.out.println("Real size: " + size);
        System.out.println();

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);
    }
    private static int findMaxParallel(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() -> IntStream.of(values)
                .parallel()
                .peek(number -> hashSet.add(Thread.currentThread())) // добавили каждый поток в hashset
                .max()
                .orElse(Integer.MIN_VALUE)).get();
    }
}
