package multithreading.tasksConcurrent.task5;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<?> future = executorService.submit(() -> new Task().getString("."));
        future.get();
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}

class Task {

    public void getString(String str) {
        if (str.contains(".")) {
            System.out.println("if");
        } else {
            System.out.println("else");
        }
    }
}
