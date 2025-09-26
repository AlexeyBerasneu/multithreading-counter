package school.sorokin.javacore.counters;

public class UnsynchronizedCounter implements SiteVisitCounter {
    private int counter;

    public UnsynchronizedCounter() {
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
