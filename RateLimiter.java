package ratelimiter;

import java.util.*;

public class RateLimiter {

    private final int limit;
    private final int windowSeconds;

    private Map<String, TreeMap<Integer, Integer>> userRequests;

    public RateLimiter(int limit, int windowSeconds) {
        this.limit = limit;
        this.windowSeconds = windowSeconds;
        this.userRequests = new HashMap<>();
    }

    public boolean allowRequest(String userId, int timestamp) {

        userRequests.putIfAbsent(userId, new TreeMap<>());
        TreeMap<Integer, Integer> requests = userRequests.get(userId);

        int windowStart = timestamp - windowSeconds + 1;

        int count = 0;

        for (Map.Entry<Integer, Integer> entry :
                requests.subMap(windowStart, true, timestamp, true).entrySet()) {
            count += entry.getValue();
        }

        if (count >= limit) {
            return false;
        }

        requests.put(timestamp, requests.getOrDefault(timestamp, 0) + 1);

        return true;
    }
}
