package multithreading.queueCashbox;
/**
 * Creates 2 cashboxes and many threads(buyers)< which working with common resource
 */

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class CashBoxMain {

    public static void main(String[] args) throws InterruptedException {
        Queue<CashBox> cashBoxes = new ArrayDeque<>(List.of(new CashBox(), new CashBox()));
        long start = System.currentTimeMillis();
        List<Thread> threads = Stream.of(
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes))
                .map(Thread::new)
                .peek(Thread::start)
                .toList();


        for (Thread thread : threads ) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
