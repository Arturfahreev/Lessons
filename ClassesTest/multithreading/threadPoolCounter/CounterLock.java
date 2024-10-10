package multithreading.threadPoolCounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock implements Counter {
    private int count;
    Lock lock = new ReentrantLock();

    public int getCount() {
        return count;
    }

    public void decrement() {
        count--;
    }

    public void increment() {
        lock.lock();
        count++;
        lock.unlock();
    }

    public void setCount(int count) {
        this.count = count;
    }
}

