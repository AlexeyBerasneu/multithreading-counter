package school.sorokin.javacore.counters;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    private int counter;

    public SynchronizedBlockCounter() {
        this.counter = 0;
    }

    @Override
    public void incrementVisitCounter() {
        synchronized (this) {
            counter++;
        }
    }

    @Override
    public int getVisitCounter() {
        synchronized (this) {
            return counter;
        }
    }
}
