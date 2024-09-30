package multithreading.threadCounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count;
    Lock lock = new ReentrantLock();

    public int getCount() {
        return count;
    }

    public void decrement() {
        count--;
    }

    public synchronized void increment() {
        //lock.lock();
        count++;
        //lock.unlock();
    }

    public void setCount(int count) {
        this.count = count;
    }
}

