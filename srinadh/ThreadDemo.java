package srinadh;

import java.util.LinkedList;

public class ThreadDemo{

    public static void main(String[] args){
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(new Producer(resource));
        Thread consumer1 = new Thread(new Consumer(resource, Priority.HIGH));
        Thread consumer2 = new Thread(new Consumer(resource, Priority.MEDIUM));
        Thread consumer3 = new Thread(new Consumer(resource, Priority.LOW));
        producer.setName("ProducerThread");
        producer.start();

        consumer1.setName("ConsumerThread1");
        consumer1.start();
        consumer2.setName("ConsumerThread2");
        consumer2.start();
        consumer3.setName("ConsumerThread3");
        consumer3.start();
    }
}

enum Priority {
    HIGH, MEDIUM, LOW
}

class Employee {
    private final int employeeId;
    private final String city;
    private final Priority priority;

    public Employee(int employeeId, String city, Priority priority) {
        this.employeeId = employeeId;
        this.city = city;
        this.priority = priority;
    }
    public Priority getPriority(){
        return this.priority;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", city='" + city + '\'' +
                ", priority=" + priority +
                '}';
    }
}
class SharedResource {
    private static final int CAPACITY = 5;
    int item = 0;
    LinkedList<Employee> queue = new LinkedList<>();
    public synchronized void addItem(Employee item){
        while(queue.size() == CAPACITY) {
            try {
                //System.out.println("Thread " + Thread.currentThread().getName() + " waiting for items to be taken");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(item);
        //System.out.println(item + " Item is added by thread " +Thread.currentThread().getName());
        notifyAll();
    }
    public synchronized void takeItem(Priority priority){
        while(queue.isEmpty() || queue.peekLast().getPriority()!= priority) {
            try {
                //System.out.println("Thread waiting :  " +Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Employee item = queue.removeLast();
        System.out.println(item + " Item is taken by thread " +Thread.currentThread().getName());
    }
}
class Producer implements Runnable {
    SharedResource resource;
    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0;i<5;i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int randomInt = (int) (Math.random() * Priority.values().length);
            resource.addItem(new Employee(i, "City" +i, Priority.values()[randomInt]));
        }
    }
}
class Consumer implements Runnable {
    SharedResource resource;
    Priority priority;
    public Consumer(SharedResource resource, Priority priority) {
        this.resource = resource;
        this.priority = priority;
    }

    @Override
    public void run() {
        for(int i = 0;i<5;i++) {
            resource.takeItem(priority);
        }
    }
}

