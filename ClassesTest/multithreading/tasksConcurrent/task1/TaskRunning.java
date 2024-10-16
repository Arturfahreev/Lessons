package multithreading.tasksConcurrent.task1;

import java.util.Scanner;

public class TaskRunning implements Runnable{


    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (sc.hasNextInt()) {
            number = sc.nextInt();
            if (number >= 0) {
                try {
                    Thread.sleep(number);
                    System.out.println("I've slept " + number + " seconds");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else return;
        }

    }
}
