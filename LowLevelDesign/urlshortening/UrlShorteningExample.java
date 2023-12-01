package LowLevelDesign.urlshortening;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

// UrlMapping class to store the mapping between short and long URLs
class UrlMapping {
    private final Map<String, String> shortToLongMap;
    private final Map<String, String> longToShortMap;

    public UrlMapping() {
        this.shortToLongMap = new ConcurrentHashMap<>();
        this.longToShortMap = new ConcurrentHashMap<>();
    }

    public String getLongUrl(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }

    public String getShortUrl(String longUrl) {
        return longToShortMap.get(longUrl);
    }

    public void addMapping(String shortUrl, String longUrl) {
        shortToLongMap.put(shortUrl, longUrl);
        longToShortMap.put(longUrl, shortUrl);
    }
}

// UrlShorteningStrategy interface
interface UrlShorteningStrategy {
    String shortenUrl();
}

// RandomUrlShorteningStrategy class implementing UrlShorteningStrategy
class RandomUrlShorteningStrategy implements UrlShorteningStrategy {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    @Override
    public String shortenUrl() {
        Random random = new Random();
        StringBuilder shortUrl = new StringBuilder();

        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            shortUrl.append(CHARACTERS.charAt(index));
        }

        return shortUrl.toString();
    }
}

// UrlShortener class responsible for shortening and expanding URLs
class UrlShortener {
    private final UrlMapping urlMapping;
    private final UrlShorteningStrategy shorteningStrategy;

    public UrlShortener(UrlMapping urlMapping, UrlShorteningStrategy shorteningStrategy) {
        this.urlMapping = urlMapping;
        this.shorteningStrategy = shorteningStrategy;
    }

    public synchronized String shortenUrl(String longUrl) {
        String shortUrl = shorteningStrategy.shortenUrl();
        urlMapping.addMapping(shortUrl, longUrl);
        return shortUrl;
    }

    public String expandUrl(String shortUrl) {
        return urlMapping.getLongUrl(shortUrl);
    }
}

// Main class to demonstrate URL shortening and expanding
public class UrlShorteningExample {

    public static void main(String[] args) {
        // Create a UrlMapping instance
        UrlMapping urlMapping = new UrlMapping();

        // Create a UrlShorteningStrategy instance
        UrlShorteningStrategy shorteningStrategy = new RandomUrlShorteningStrategy();

        // Create a UrlShortener instance with the UrlMapping and UrlShorteningStrategy
        UrlShortener urlShortener = new UrlShortener(urlMapping, shorteningStrategy);

        // Original long URLs
        String longUrl1 = "https://www.example.com/page1";
        String longUrl2 = "https://www.example.com/page2";

        // Simulate multiple thread requests
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                String shortUrl = urlShortener.shortenUrl(longUrl1);
                System.out.println(longUrl1 + "Thread 1 - Shortened URL: " + shortUrl);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                String shortUrl = urlShortener.shortenUrl(longUrl2);
                System.out.println(longUrl2 + "Thread 2 - Shortened URL: " + shortUrl);
            }
        };

        // Create and start threads
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            // Wait for threads to complete
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final state of URL mappings
        System.out.println("\nFinal URL Mappings:");
        System.out.println("Long URL 1: " + urlShortener.expandUrl(urlShortener.shortenUrl(longUrl1)));
        System.out.println("Long URL 2: " + urlShortener.expandUrl(urlShortener.shortenUrl(longUrl2)));
    }
}
