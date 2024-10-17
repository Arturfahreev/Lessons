package multithreading.forkJoinPool;

/**
 * Fill in an array with int, then sum it members by many threads using analog of ForkJoinPool
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainManyTreads {
    public static int[] array = new int[100_000_000];
    // 4 999 999 950 000 000 (100_000_000) Time 51 (many) Time 62 (single)
    //       499 999 500 000 (1_000_000) Time 25 (many) Time 28 (single)
    //                   499 500 (1_000) Time 18 (many) Time 0 (single)

    public static int processors = Runtime.getRuntime().availableProcessors();

    private static List<Future<Long>> list = new ArrayList<>();
    private static List<Long> listResult = new ArrayList<>();
    private static List<ExecutorService> listExecute = new ArrayList<>();
    static {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        int step = array.length / processors;
        int part = step;
        for (int i = 0; i < array.length;) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            list.add(executorService.submit(new MyCallable(i, part)));
            listExecute.add(executorService);
            //System.out.println("Main before " + "i = " + i + " part = " + part);
            i += step;
            part += step;
//            System.out.println("Main after " + "i = " + i + " part = " + part);
        }

        for (Future<Long> future : list) {
            listResult.add(future.get());
        }
        long result = 0;
        for (Long number : listResult) {
            result += number;
        }
//        long result = listResult.stream()
//                .mapToLong(Long::longValue)
//                .sum();
        for (ExecutorService executorService : listExecute) {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        }
        System.out.println("Time " + (System.currentTimeMillis() - start));
        System.out.printf("Sum: %,d", result);
    }

    static class MyCallable implements Callable<Long> {

        int from;
        int to;

        public MyCallable(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0;
//            System.out.println("Callable " + from + " " + to);
            for (int i = from; i < to; i++) {
                if (i < array.length) {
                    sum += array[i];
                }
            }
            return sum;
        }
    }
}


