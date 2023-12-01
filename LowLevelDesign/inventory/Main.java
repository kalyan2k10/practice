package LowLevelDesign.inventory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

// Message class representing a generic message
class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// OrderMessage class extending Message, representing an order message
class OrderMessage extends Message {
    private final String orderId;
    private final String itemName;
    private final int quantity;

    public OrderMessage(String orderId, String itemName, int quantity) {
        super("Order: " + orderId + " - " + itemName + " x" + quantity);
        this.orderId = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }
}

// MessageQueue class managing the message queue
class MessageQueue {
    private static Queue<Message> messageQueue = new LinkedList<>();

    public static void sendMessage(Message message) {
        // Add message to the queue
        messageQueue.add(message);
    }

    public static Message receiveMessage() {
        // Retrieve and remove the first message from the queue
        return messageQueue.poll();
    }

    public static void sendAcknowledgment(String orderId, String acknowledgment) {
        // Acknowledge successful processing (e.g., update order status in the database)
        System.out.println("Order ID: " + orderId + " - " + acknowledgment);
    }
}

// OrderService class generating order messages and sending them to the message queue
class OrderService {
    public void placeOrder(String itemName, int quantity) {
        // Generate unique order ID
        String orderId = UUID.randomUUID().toString();

        // Create order message
        OrderMessage orderMessage = new OrderMessage(orderId, itemName, quantity);

        // Send order message to the message queue
        MessageQueue.sendMessage(orderMessage);
    }
}

// InventoryService class processing order messages and updating inventory
class InventoryService {
    public void processOrder(OrderMessage orderMessage) {
        // Retrieve order details from the message
        String orderId = orderMessage.getOrderId();
        String itemName = orderMessage.getItemName();
        int quantity = orderMessage.getQuantity();

        // Update inventory based on the order
        // (Implementation details depend on the actual inventory management logic)
        InventoryManager.updateInventory(itemName, quantity);

        // Optionally: Acknowledge successful order processing
        MessageQueue.sendAcknowledgment(orderId, "Order processed successfully");
    }
}

// PaymentService class processing order messages and handling payments
class PaymentService {
    public void processOrder(OrderMessage orderMessage) {
        // Retrieve order details from the message
        String orderId = orderMessage.getOrderId();
        // Payment processing logic
        // (Implementation details depend on the actual payment processing logic)

        // Optionally: Acknowledge successful payment processing
        MessageQueue.sendAcknowledgment(orderId, "Payment processed successfully");
    }
}

// InventoryManager class representing the inventory and updating inventory
class InventoryManager {

    private static int batQuantity = 0;
    private static int ballQuantity = 0;

    public static void updateInventory(String itemName, int quantity) {
        switch (itemName) {
            case "Bat":
                batQuantity += quantity;
                break;
            case "Ball":
                ballQuantity += quantity;
                break;
            // Add more cases for other items if needed
        }
    }

    public static void displayInventory() {
        System.out.println("Bats in Inventory: " + batQuantity);
        System.out.println("Balls in Inventory: " + ballQuantity);
        // Add more display statements for other items if needed
    }
}




// Main class simulating the order processing flow
public class Main {

    public static void main(String[] args) {
        // Simulate initial inventory
        InventoryManager.updateInventory("Bat", 2);
        InventoryManager.updateInventory("Ball", 2);

        // Simulate order placement
        OrderService orderService = new OrderService();
        orderService.placeOrder("Bat", 1);
        orderService.placeOrder("Ball", 1);

        // Simulate order processing
        InventoryService inventoryService = new InventoryService();
        PaymentService paymentService = new PaymentService();

        // Check for new messages in the queue and process orders
        while (true) {
            Message orderMessage = MessageQueue.receiveMessage();
            if (orderMessage == null) {
                break; // No more messages in the queue
            }

            if (orderMessage instanceof OrderMessage) {
                OrderMessage order = (OrderMessage) orderMessage;

                // Process the order in inventory and payment services
                inventoryService.processOrder(order);
                paymentService.processOrder(order);
            }
        }

        // Display final inventory status
        System.out.println("\nFinal Inventory Status:");
        InventoryManager.displayInventory();
    }
}
