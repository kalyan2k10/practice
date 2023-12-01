package LowLevelDesign.ratelimiter;


import java.util.HashMap;
import java.util.Map;

class RateLimiter {
    private int limit; // Maximum allowed requests
    private long interval; // Time window for the limit in milliseconds
    private Map<String, Client> clients;

    public RateLimiter(int limit, long interval) {
        this.limit = limit;
        this.interval = interval;
        this.clients = new HashMap<>();
    }

    public boolean allowRequest(String clientID) {
        if (!clients.containsKey(clientID)) {
            clients.put(clientID, new Client(clientID));
        }

        Client client = clients.get(clientID);

        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - client.getLastRequestTime();

        if (elapsedTime >= interval) {
            // Reset requests counter if the interval has passed
            client.resetRequests();
        }

        if (client.getRequestsMade() < limit) {
            // Allow the request and update the counter
            client.incrementRequests();
            client.setLastRequestTime(currentTime);
            return true;
        } else {
            // Deny the request
            return false;
        }
    }
}

class Client {
    private String clientID;
    private int requestsMade;
    private long lastRequestTime;

    public Client(String clientID) {
        this.clientID = clientID;
        this.requestsMade = 0;
        this.lastRequestTime = 0;
    }

    public int getRequestsMade() {
        return requestsMade;
    }

    public void incrementRequests() {
        this.requestsMade++;
    }

    public void resetRequests() {
        this.requestsMade = 0;
    }

    public long getLastRequestTime() {
        return lastRequestTime;
    }

    public void setLastRequestTime(long lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }
}

public class RateLimiterApp {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5, 5000); // Allow 5 requests per 10 seconds

        String clientID = "client1";

        // Attempt to make requests
        for (int i = 0; i < 6; i++) {
            boolean allowed = rateLimiter.allowRequest(clientID);
            if (allowed) {
                System.out.println("Request #" + (i + 1) + " allowed");
            } else {
                System.out.println("Request #" + (i + 1) + " denied (Rate limit exceeded)");
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            boolean allowed = rateLimiter.allowRequest(clientID);
            if (allowed) {
                System.out.println("Request #" + (i + 1) + " allowed");
            } else {
                System.out.println("Request #" + (i + 1) + " denied (Rate limit exceeded)");
            }
        }
    }
}

