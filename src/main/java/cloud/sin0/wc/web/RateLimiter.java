package cloud.sin0.wc.web;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongSupplier;

/** In-memory sliding-window limiter (per key, e.g. client IP) for the anonymous capture route. */
public class RateLimiter {

    private static final int SWEEP_EVERY = 512;

    private final int maxEvents;
    private final long windowMillis;
    private final LongSupplier clock;
    private final ConcurrentHashMap<String, Deque<Long>> hits = new ConcurrentHashMap<>();
    private int calls;

    public RateLimiter(int maxEvents, long windowMillis) {
        this(maxEvents, windowMillis, System::currentTimeMillis);
    }

    RateLimiter(int maxEvents, long windowMillis, LongSupplier clock) {
        this.maxEvents = maxEvents;
        this.windowMillis = windowMillis;
        this.clock = clock;
    }

    /** Records an event for {@code key}; false when the key already used its quota in the window. */
    public boolean allow(String key) {
        long now = clock.getAsLong();
        Deque<Long> q = hits.computeIfAbsent(key == null ? "" : key, k -> new ArrayDeque<>());
        boolean ok;
        synchronized (q) {
            while (!q.isEmpty() && now - q.peekFirst() >= windowMillis) {
                q.pollFirst();
            }
            ok = q.size() < maxEvents;
            if (ok) {
                q.addLast(now);
            }
        }
        if (++calls % SWEEP_EVERY == 0) {
            sweep(now);
        }
        return ok;
    }

    private void sweep(long now) {
        hits.entrySet().removeIf(e -> {
            synchronized (e.getValue()) {
                return e.getValue().isEmpty() || now - e.getValue().peekLast() >= windowMillis;
            }
        });
    }
}
