package multithreading.forkJoinPool;

public class MainSingleThread {
    public static void main(String[] args) {
        int[] array = new int[100_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Time " + (System.currentTimeMillis() - start));
        System.out.println("Sum " + sum);
    }
}
