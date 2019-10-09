package top.clearlight.book.coretech.thread;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A bank with a number of bank account
 *
 * @date 2019.10.08
 */
public class Bank {
    private final double[] accounts;

    /**
     * Constructs the bank
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    private ReentrantLock lock = new ReentrantLock();

    /**
     * Transfers money from one account to another
     */
    public void transfer(int from, int to, double amount) {
        lock.lock();
        try {
            if (accounts[from] < amount) {
                return;
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            lock.unlock();
        }
    }

    /**
     * Gets the sum of all account balances.
     *
     * @return the total balance
     */
    private double getTotalBalance() {
        double sum = 0;
        for (double a :
                accounts) {
            sum += a;
        }

        return sum;
    }

    /**
     * Gets the number of accounts in the bank.
     */
    public int size() {
        return accounts.length;
    }
}
