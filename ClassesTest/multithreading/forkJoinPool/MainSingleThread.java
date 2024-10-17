package multithreading.forkJoinPool;

/**
 * Fill in an array with numbers^ then sum it's members by single thread to compare time in performing
 * this task by many threads.
 */

public class MainSingleThread {
    public static void main(String[] args) {
        int[] array = new int[80_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Time " + (System.currentTimeMillis() - start));
        System.out.printf("Sum %,d", sum);
    }
}
