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
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(array);
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
}

class MyRecursiveTask extends RecursiveTask<Long> {
    int[] array;

    public MyRecursiveTask(int[] array) {
        this.array = array;
    }

    @Override
    protected Long compute() {
        if (array.length <= MainForkJoinPool.part) {
            MainForkJoinPool.setThread.add(Thread.currentThread());
            return Arrays.stream(array).asLongStream().sum();
        }
        MyRecursiveTask task1 = new MyRecursiveTask(Arrays.copyOfRange(array, 0, array.length / 2));
        MyRecursiveTask task2 = new MyRecursiveTask(Arrays.copyOfRange(array, array.length / 2, array.length));
        task1.fork();
        task2.fork();
        return task1.join() + task2.join();
    }
}
