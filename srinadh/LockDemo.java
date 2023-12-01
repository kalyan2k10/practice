package srinadh;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        MyResource sharedResource = new MyResource(lock);
        MyResource sharedResource2 = new MyResource(lock);
        Thread th1 = new Thread(() -> {
            sharedResource.produce();
        });
        Thread th2 = new Thread(() ->{
            sharedResource2.produce();
        });
        th1.start();
        th2.start();
    }
}
class MyResource {
    boolean isAvailable = false;
    Lock lock;

    public MyResource(Lock lock) {
        this.lock = lock;
    }

    public void produce(){
        lock.lock();
        try {
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isAvailable = true;
            System.out.println("Lock released by " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }
}
