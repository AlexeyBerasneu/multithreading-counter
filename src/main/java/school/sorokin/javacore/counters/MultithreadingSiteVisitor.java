package school.sorokin.javacore.counters;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingSiteVisitor extends Thread {
    private final SiteVisitCounter visitCounter;
    private final List<Thread> threads = new ArrayList<>();
    private long startTime;
    private long endTime;

    public MultithreadingSiteVisitor(SiteVisitCounter visitCounter) {
        this.visitCounter = visitCounter;
    }

    public void visitMultithread(int numOfThreads) {
        startTime = System.currentTimeMillis();
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                visitCounter.incrementVisitCounter();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        for (int i = 0; i < numOfThreads; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
    }

    public void waitUntilAllVisited() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        endTime = System.currentTimeMillis();
    }

    public double getTotalTimeOfHandling() {
        return (endTime - startTime) / 1000.0;
    }
}
