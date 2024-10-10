package multithreading.threadPoolCounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterSynchronized implements Counter {
    private int count;

    public int getCount() {
        return count;
    }

    public void decrement() {
        count--;
    }

    public synchronized void increment() {
        count++;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
