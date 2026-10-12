package core.java.practice.leet.code2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterService {
    private static final int MAX_REQUESTS = 10;
    private static final long WINDOW_MS = 60_000; // 1 minute
    private final Map<String, RequestCounter> requests = new ConcurrentHashMap<>();

    public boolean allowRequest(String key) {
        long now = System.currentTimeMillis();

        RequestCounter counter = requests.computeIfAbsent(
                key, k -> new RequestCounter(now)
        );

        synchronized (counter) {
            if (now - counter.startTime >= WINDOW_MS) {
                counter.startTime = now;
                counter.count = 0;
            }

            if (counter.count >= MAX_REQUESTS) {
                return false;
            }

            counter.count++;
            return true;
        }
    }

    private static class RequestCounter {
        long startTime;
        int count;

        RequestCounter(long startTime) {
            this.startTime = startTime;
        }
    }
}
