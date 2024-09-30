package multithreading.threadCounter;

public class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            counter.increment();
        }
    }
}
