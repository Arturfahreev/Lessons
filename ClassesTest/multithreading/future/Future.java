package multithreading.future;

import java.util.concurrent.CompletableFuture;

public class Future {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(4);
//        Future future = threadPool.submit(() ->
//        {
//            try {
//
//                Thread.sleep(2000l);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            // задача 1
            System.out.println("Задача 1 выполнена");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            // задача 2
            System.out.println("Задача 2 выполнена");
        });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);

        combinedFuture.thenRun(() -> {
            System.out.println("Все задачи выполнены");
        });
    }
}
