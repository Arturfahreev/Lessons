package multithreading.queueCashbox;


import java.util.Queue;

public class BuyerThread implements Runnable {
    private final Queue<CashBox> queue;

    public BuyerThread(Queue<CashBox> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            synchronized (queue) {
                while (true) {
                    if (!queue.isEmpty()) {
                        CashBox cashBox = queue.remove();
                        System.out.println(Thread.currentThread().getName() + " get " + cashBox);
                        queue.wait(5);

                        queue.add(cashBox);
                        System.out.println(Thread.currentThread().getName() + " released " + cashBox);
                        queue.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " is waiting");
                        queue.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
