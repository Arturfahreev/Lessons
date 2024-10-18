package multithreading.forkJoinPool;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * 2.Задан массив случайных целых чисел (от 1 до 300)
 * случайной длины (до 1 млн элементов).
 * Найти максимальный элемент в массиве двумя способами: в
 * одном потоке и используя 10 потоков.
 * Сравнить затраченное в обоих случаях время.
 *
 * ПРИМЕЧАНИЕ:
 * Изначально на уроке применялся метод parallel в Stream, который обернули в ExecutorService с 10 потоками,
 * Но внимательное изучение и вывод потоков показал, что там не 10 потоков.
 * Создавая свой FJP дает планируемый результат выполнения задачи в 10 потоков.
 */

public class TaskFromDmdev {
    // новое поле set, чтобы включать туда потоки и потом посчитать сколько было уникальных
    private static Set<Thread> hashSet = new HashSet<>();
    // новое поле array для FJP
    private static int[] valuesFJP;
    // новое поле int с количство thread по задаче
    private static final int threads = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] values = new int[100_000_000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(300) + 1;
        }
        valuesFJP = values;


        ExecutorService threadPool = Executors.newFixedThreadPool(threads); // ставим 10 потоков
//        trackTime(() -> {
//            try {
//                return findMaxParallel(values, threadPool);
//            } catch (ExecutionException | InterruptedException e) {
//                e.printStackTrace();
//            }
//            return Integer.MIN_VALUE;
//        });

        /**
         * Добавили новый метод, чтобы проверить количество потоков
         */

        trackTime( () -> {
            try {
                return findMaxParallelPeek(values, threadPool);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //trackTime(() -> findMax(values));

        threadPool.shutdownNow();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);

        /**
         * Теперь выводим содержимое hashset и смотрим сколько же на самом деле было потоков после вызова parallel()
         * Вывод в консоль:
         * 300: 1167
         * pool-1-thread-1
         * ForkJoinPool.commonPool-worker-5
         * ForkJoinPool.commonPool-worker-3
         * ForkJoinPool.commonPool-worker-7
         *
         * Это явно не 10 потоков. Потому что использовался стандартный FJP.
         */
        for (Thread thread : hashSet) {
            System.out.println(thread.getName());
        }
        hashSet.clear();

        /**
         * Теперь пытаемся решить эту же задачу, но создавая свой кастомный FJP и RecursiveTask
         */

        ForkJoinPool forkJoinPool = new ForkJoinPool(threads);
        MyRecursiveTaskFJP myRecursiveTask = new MyRecursiveTaskFJP(0, valuesFJP.length);
        long start = System.currentTimeMillis();
        Integer result = forkJoinPool.invoke(myRecursiveTask);
        long resultTime = System.currentTimeMillis() - start;
        System.out.printf("Max: %d Time: %d%n", result, resultTime);
        for (Thread thread : hashSet) {
            System.out.println(thread.getName());
        }

        /**
         * Вывод на консоль после применения FJP:
         *
         * Max: 300 Time: 252
         * ForkJoinPool-1-worker-31
         * ForkJoinPool-1-worker-19
         * ForkJoinPool-1-worker-9
         * ForkJoinPool-1-worker-3
         * ForkJoinPool-1-worker-17
         * ForkJoinPool-1-worker-23
         * ForkJoinPool-1-worker-27
         * ForkJoinPool-1-worker-5
         * ForkJoinPool-1-worker-13
         * ForkJoinPool-1-worker-21
         *
         * Вот здесь уже 10 потоков. И время выполнения на порядок быстрее, сравнивая с применением parallel().
         */

    }

    private static int trackTime(Supplier<Integer> task) {
        long startTime = System.currentTimeMillis();
        int result = task.get();
        System.out.println(result + ": " + (System.currentTimeMillis() - startTime));
        return result;
    }

    private static int findMax(int[] values) {
        return IntStream.of(values)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private static int findMaxParallel(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() -> IntStream.of(values)
                .parallel()
                /**
                 * В этом месте будет использоваться стандартный common ForkJoinPoll (FJP) количство потоков которого
                 * будет равно числу процессоров. А нам по задаче нужно использовать 10 потоков для решения.
                 * Поэтому нужно создавать свои RecursiveTask и свой кастомный FJL в 10 потоков.
                 * Как проверить что используя parallel() мы не используем 10 потоков, которые якробы передали вместе с executorService?
                 * достаточно сделать peek() и вывести через консоль имя каждого Thread.currentThread().getName()
                 * Но учитывая что элементов 100_000_000, поэтому нет возможности выводить имя каждого потока на консоль.
                 * Проще создать hashset и помещать туда потока и потом вывести на экран содержимое - это и будет количство наших потоков.
                 */
                .max()
                .orElse(Integer.MIN_VALUE)).get();
    }

    /**
     * Пишем такой же метод как и выше, но добавляем метод peek и проверяем сколько выведет в консоли thread'ов.
     */

    private static int findMaxParallelPeek(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() -> IntStream.of(values)
                .parallel()
                .peek(number -> hashSet.add(Thread.currentThread())) // добавили каждый поток в hashset
                .max()
                .orElse(Integer.MIN_VALUE)).get();
    }

    /**
     * Создаем новый класс для FJP
     */

    public static class MyRecursiveTaskFJP extends RecursiveTask<Integer> {

        int from;
        int to;

        public MyRecursiveTaskFJP(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Integer compute() {
            if ((to - from) <= (valuesFJP.length / threads)) { // порог входа
                hashSet.add(Thread.currentThread());
                int max = Integer.MIN_VALUE;
                for (int i = from; i < to ; i++) {
                    if (valuesFJP[i] > max) {
                        max = valuesFJP[i];
                    }
                }
                return max;
            }

            MyRecursiveTaskFJP task1 = new MyRecursiveTaskFJP(from, ((to - from) / 2) + from); // делим задачу пополам
            MyRecursiveTaskFJP task2 = new MyRecursiveTaskFJP(((to - from) / 2) + from, to);
            task2.fork();
            task1.fork();
            return Integer.max(task1.join(), task2.join());
        }
    }


}
