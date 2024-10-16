package multithreading.tasksConcurrent.task3;

/**
 * Search max in array by one thread and many (10), and to compare timing between them
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class Main {
    public static int[] array;
    public static Random random = new Random();
    private static Set<Thread> setSingle = new HashSet<>();
    private static Set<Thread> setParallel = new HashSet<>();
    private static Set<Thread> setFixedThreadPool = new HashSet<>();

    public static void main(String[] args) throws InterruptedException {
        generateArray();
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();

        ExecutorService executorServiceFixed = Executors.newFixedThreadPool(10);

        //trackTime(() -> findMax(array, executorServiceSingle));
        //trackTime(() -> findMaxParallel(array));
        trackTime(() -> findMaxFixedThreadPool(array, executorServiceFixed));

        executorServiceSingle.shutdown();
        executorServiceSingle.awaitTermination(1, TimeUnit.MINUTES);
        executorServiceFixed.shutdown();
        executorServiceFixed.awaitTermination(1, TimeUnit.MINUTES);
    }

    public static int trackTime (Supplier<Integer> supplier) {
        long start = System.currentTimeMillis();
        Integer result = supplier.get();
        System.out.println("Time " + (System.currentTimeMillis() - start));
        System.out.println();
        return result;

    }
    private static int findMaxParallel(int[] array) {
        int result = Arrays.stream(array)
                .parallel()
                .peek(text -> setParallel.add(Thread.currentThread()))
                .max()
                .orElse(Integer.MIN_VALUE);
        for (Thread thread : setParallel) {
            System.out.println("StreamParallel " + thread.getName());
        }
        return result;
    }

    private static int findMaxFixedThreadPool(int[] array, ExecutorService executorService) {
        Future<Integer> future = executorService.submit(() -> Arrays.stream(array)
                .parallel()
                .peek(text -> setFixedThreadPool.add(Thread.currentThread()))
                .max()
                .orElse(Integer.MIN_VALUE));
        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        for (Thread thread : setFixedThreadPool) {
            System.out.println("FixedThreadPool " + thread.getName());
        }

        return result;

    }

    private static int findMax(int[] array, ExecutorService executorService)  {
        Future<Integer> future = executorService.submit(() -> Arrays.stream(array)
                .peek(text -> setSingle.add(Thread.currentThread()))
                .max()
                .orElse(Integer.MIN_VALUE));
//        Stream.of(setSingle)
//                .forEach(n -> System.out.println("SingleExecutor " + n.toString()));
        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        for (Thread thread : setSingle) {
            System.out.println("SingleExecutor " + thread.getName());
        }
        return result;

    }

    private static void generateArray() {
        array = new int[100_000_000];
        array = Arrays.stream(array)
                .map(number -> random.nextInt(3000))
                .toArray();
    }
}


