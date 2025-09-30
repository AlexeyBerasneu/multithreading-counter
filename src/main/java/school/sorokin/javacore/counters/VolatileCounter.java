package school.sorokin.javacore.counters;

public class VolatileCounter implements SiteVisitCounter {
    private volatile int counter;

    public VolatileCounter() {
        this.counter = 0;
    }

    @Override
    public void incrementVisitCounter() {
        counter++;
    }

    @Override
    public int getVisitCounter() {
        return counter;
    }
}
