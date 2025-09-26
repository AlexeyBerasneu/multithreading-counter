package school.sorokin.javacore.counters;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements SiteVisitCounter {
    private final ReentrantLock lock = new ReentrantLock();
    private int counter;

    public ReentrantLockCounter() {
        this.counter = 0;
    }

    @Override
    public void incrementVisitCounter() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }

    }

    @Override
    public int getVisitCounter() {
        return counter;
    }
}
