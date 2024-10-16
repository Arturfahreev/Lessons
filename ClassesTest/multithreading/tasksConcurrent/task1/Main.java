package multithreading.tasksConcurrent.task1;

import java.util.Scanner;

/**
 * Write a program which reading users integer inputs and sleeping for this seconds in one the same tread.
 * If integer is negative number, program should exit.
 * It should be 2 threads: main and thread for task.
 */

public class Main {
    public static void main(String[] args) {
        TaskRunning taskRunning = new TaskRunning();
        Thread thread = new Thread(taskRunning);
        thread.start();

    }

}
