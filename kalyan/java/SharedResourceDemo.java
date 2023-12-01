package kalyan.java;

import java.util.LinkedList;

public class SharedResourceDemo {
    private static final int CAPACITY = 1;
    LinkedList<Employee> queue = new LinkedList<>();
    public SharedResourceDemo(){

    }
    public synchronized void add(Employee emp){
        while(queue.size() == CAPACITY) {
            System.out.println(Thread.currentThread().getName() + "Will wait until someone takes the item ");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.addFirst(emp);
        System.out.println(emp + " Item has been added by" + Thread.currentThread().getName());
        notifyAll();
    }
    public synchronized Employee take(Priority priority) {
        while(queue.isEmpty() || queue.peekLast().getPriority() != priority){
            System.out.println(Thread.currentThread().getName() + "Will wait until someone adds the item ");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Employee emp = queue.removeLast();
        System.out.println(emp + " Item has been taken by " + Thread.currentThread().getName());
        notifyAll();
        return emp;
    }

    public static void main(String[] args) {
        SharedResourceDemo sharedResource = new SharedResourceDemo();
        Thread producer = new Thread(() -> {
            for(int i=0;i<5;i++) {
                int index = (int) (Math.random() * Priority.values().length);
                Employee e = new Employee(i, "City"+i, Priority.values()[index]);
                sharedResource.add(e);
            }
        });
        Thread consumerLow = new Thread(() -> {
            for(int i=0;i<5;i++)
                sharedResource.take(Priority.LOW);
        });
        Thread consumerMedium= new Thread(() -> {
            for(int i=0;i<5;i++)
                sharedResource.take(Priority.MEDIUM);
        });
        Thread consumerHigh = new Thread(() -> {
            for(int i=0;i<5;i++)
                sharedResource.take(Priority.HIGH);
        });
        producer.setName("ProducerThread");
        consumerMedium.setName("ConsumerThreadMedium");
        consumerLow.setName("ConsumerThreadLow");
        consumerHigh.setName("ConsumerThreadHigh");
        producer.start();
        consumerMedium.start();
        consumerLow.start();
        consumerHigh.start();
    }
}
