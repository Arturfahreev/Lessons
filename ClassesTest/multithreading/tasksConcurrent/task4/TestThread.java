package multithreading.tasksConcurrent.task4;

import java.util.ArrayList;
import java.util.List;

/**
 * program shows different in time between calculating in threads and in main thread only
 */

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> listThread = new ArrayList<>();
        List<ArrayFill> listArrayFill = new ArrayList<>();
        int count = 40;

        for (int i = 0; i < count; i++) {
            listThread.add(new Thread(new MyThread()));
        }

        long before = System.currentTimeMillis();

        for (Thread thread : listThread) {
            thread.start();
        }
        for (Thread thread : listThread) {
            thread.join();
        }

        long after = System.currentTimeMillis();

        System.out.println(after - before);


        for (int i = 0; i < count; i++) {
            listArrayFill.add(new ArrayFill());
        }

        before = System.currentTimeMillis();

        for (ArrayFill arrayFill : listArrayFill) {
            arrayFill.doWork();
        }

        after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}

class MyThread implements Runnable {

    private List<Integer> list = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < 2_000_000; i++) {
            list.add(i);
        }
    }

    public List<Integer> getList() {
        return list;
    }
}

class ArrayFill {

    private List<Integer> list = new ArrayList<>();

    void doWork() {
        for (int i = 0; i < 2_000_000; i++) {
            list.add(i);
        }
    }
}
