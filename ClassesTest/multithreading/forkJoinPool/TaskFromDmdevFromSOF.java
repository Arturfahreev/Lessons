package multithreading.forkJoinPool;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TaskFromDmdevFromSOF {

    public static void main(String[] args) throws InterruptedException, ExecutionException, CancellationException {
        int[] values = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(300) + 1;
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        int step = values.length / 10;
        int max = IntStream.range(0, 10)
                .mapToObj(i -> threadPool.submit(() -> getSum(values, i * step, (i + 1) * step)))
                .toList()
                .stream()
                .mapToInt(x -> {
                    try {
                        return x.get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .max()
                .orElseThrow();


    }
    private static int getSum (int[] array, int from, int to) {
        return Arrays.stream(array).sum();
    }
}
