package multithreading.tasksConcurrent.task2;

/**
 * Write a program which reading users integer inputs and sleeping for those seconds.
 * Tasks should start on several threads by ExecutorService.
 * If integer is negative number, program should exit.
 * It should be 2 threads: main and thread for task.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int number = 0;
        while (sc.hasNextInt()) {
            number = sc.nextInt();
            if (number >= 0) {
                executorService.submit(new TaskRunning(number));
            } else {
                for (var entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " number of tasks: " + entry.getValue());
                }
                executorService.shutdown();
                executorService.awaitTermination(1000, TimeUnit.MINUTES);
                return;
            }
        }
    }
}

class TaskRunning implements Runnable {
    private int number;

    public TaskRunning(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(number);
            String name = Thread.currentThread().getName();
            Main.map.putIfAbsent(name, 0);
            Main.map.put(name, Main.map.get(name) + 1);
            System.out.println("I've slept " + number + " seconds");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
