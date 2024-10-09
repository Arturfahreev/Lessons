package multithreading.deadLock;

import java.util.Random;

public class AccountTread extends Thread {

    private Account accountTo;
    private Account accountFrom;
    Random random = new Random();

    public AccountTread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            try {
                lockAccounts();
                if (accountFrom.takeOff(10)) {
                    System.out.println(j + " " + Thread.currentThread().getName() + " " + accountFrom + " took off ");
                    accountTo.add(10);
                    System.out.println(j + " " + Thread.currentThread().getName() + " " + accountTo + " added");

                }
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }
        }
    }

        private void lockAccounts () {
            while (true) {
                boolean fromLockResult = accountFrom.getLock().tryLock();
                boolean toLockResult = accountTo.getLock().tryLock();
                if (fromLockResult && toLockResult) {
                    break;
                }
                if (fromLockResult) {
                    accountFrom.getLock().unlock();
                }
                if (toLockResult) {
                    accountTo.getLock().unlock();
                }
            }
        }
    }



