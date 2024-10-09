package multithreading.deadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private static int generator = 1;
    private int id;
    int balance;

    public Account(int balance) {
        this.balance = balance;
        id = generator++;

    }

    public void add(int money) {
        this.balance += money;
    }

    public boolean takeOff(int money) {
        if (balance >= money) {
            balance -= money;
            return true;
        } else return false;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
