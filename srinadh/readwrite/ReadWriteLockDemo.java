package srinadh.readwrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource resource = new SharedResource();
        Thread producer = new Thread(() -> {
            resource.produce(lock);
        });
        Thread consumer = new Thread(() -> {
            resource.consume(lock);
        });
        Thread consumer2 = new Thread(() -> {
            resource.consume(lock);
        });
        producer.start();
        consumer.start();
        consumer2.start();
    }
}

class SharedResource {
    boolean isAvaialable;

    public void produce(ReadWriteLock lock) {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " acquired the lock.");
        try {
            isAvaialable = true;
            System.out.println("isAvaialable "+isAvaialable);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        System.out.println(Thread.currentThread().getName() + " released the lock.");
    }

    public void consume(ReadWriteLock lock) {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " acquired the lock.");
        try {
            System.out.println("isAvaialable "+isAvaialable);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.readLock().unlock();
        }
        System.out.println(Thread.currentThread().getName() + " released the lock.");
    }
}