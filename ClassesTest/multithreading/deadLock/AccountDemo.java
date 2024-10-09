package multithreading.deadLock;

import java.util.List;
import java.util.stream.Stream;

/**
 * Transfer money from one account to another throughout different threads
 */

public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(10000);
        Account account2 = new Account(10000);
        List<AccountTread> accountTreads = Stream.of(
                        new AccountTread(account1, account2),
                        new AccountTread(account1, account2),
                        new AccountTread(account1, account2),
                        new AccountTread(account2, account1),
                        new AccountTread(account2, account1),
                        new AccountTread(account2, account1)
                )
                        .peek(Thread::start)
                        .toList();
        for (Thread thread : accountTreads) {
            thread.join();
        }
        System.out.println(account1);
        System.out.println(account2);
    }
}
