package school.sorokin.javacore.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    private AtomicInteger counter;

    public AtomicIntegerCounter() {
        this.counter = new AtomicInteger(0);
    }

    @Override
    public void incrementVisitCounter() {
        counter.incrementAndGet();
    }

    @Override
    public int getVisitCounter() {
        return counter.get();
    }
}
