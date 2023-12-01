package kalyan.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLockAndPriority {
    public static void main(String[] args) {
        // Shared resource
        Buffer buffer = new Buffer(5);

        // Create producer and consumer threads with different priorities
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread1 = new Thread(new Consumer(buffer, "Consumer 1"));
        Thread consumerThread2 = new Thread(new Consumer(buffer, "Consumer 2"));

        // Set priority for consumer threads
        consumerThread1.setPriority(Thread.MAX_PRIORITY); // Highest priority
        consumerThread2.setPriority(Thread.MIN_PRIORITY); // Lowest priority

        // Start the threads
        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}

class Buffer {
    private final Queue<Integer> queue;
    private final int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void produce(int item) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("Buffer is full. Producer is waiting.");
                notFull.await();
            }

            System.out.println("Producing: " + item);
            queue.offer(item);
            notEmpty.signalAll(); // Notify all consumers that the buffer is not empty now
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int consume() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Buffer is empty. Consumer is waiting.");
                notEmpty.await();
            }

            int item = queue.poll();
            System.out.println(Thread.currentThread().getName() + " is consuming: " + item);
            notFull.signalAll(); // Notify all producers that the buffer is not full now
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(1000); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final Buffer buffer;
    private final String name;

    public Consumer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.consume();
            try {
                Thread.sleep(1500); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
