package kalyan.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Balance{
    private int balance = 0;
    ReadWriteLock lock;
    public int getBalance() {
        return balance;
    }

    public Balance(ReadWriteLock lock){
        this.lock = lock;
    }
    public synchronized  void updateBalance(int amount) {
        System.out.println(Thread.currentThread().getName() + " Acquired the write lock");
        try {
            balance = balance + amount;
            System.out.println(Thread.currentThread().getName() + " Updated balnace : " + balance);
        } finally {
            System.out.println(Thread.currentThread().getName() + " Released the write lock");
        }
    }

    public void process(int amount) {
        System.out.println(Thread.currentThread().getName() + " Request cam to update the balance with amount " + amount);
        while(balance + amount < 0){
            try {
                System.out.println(Thread.currentThread().getName() + " Will wait for sometime and check balance again");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(balance + amount < 0) {
                throw new RuntimeException("balance cannot go negative");
            } else {
                break;
            }
        }
        updateBalance(amount);
    }
}
public class BalanceDemo {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Balance balanceObj = new Balance(lock);
        Thread thread1 = new Thread(() ->{
            balanceObj.process(-200);
        });
        Thread thread2 = new Thread(() ->{
            balanceObj.process(-300);
        });
        Thread thread3 = new Thread(() ->{
            balanceObj.process(800);
        });
        thread1.setName("Thread1");
        thread1.start();
        thread2.setName("Thread2");
        thread2.start();
        thread3.setName("Thread3");
        thread3.start();
    }
}
