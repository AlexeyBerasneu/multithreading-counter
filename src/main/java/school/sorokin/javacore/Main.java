package school.sorokin.javacore;

import school.sorokin.javacore.counters.*;

import java.util.List;

public class Main {
    private static List<SiteVisitCounter> siteVisitCounterList = List.of(
            new UnsynchronizedCounter(),
            new AtomicIntegerCounter(),
            new VolatileCounter(),
            new ReentrantLockCounter(),
            new SynchronizedBlockCounter()
    );

    public static void main(String[] args) {
        for (SiteVisitCounter siteVisitCounter : siteVisitCounterList) {
            System.out.printf("**********%s**********\n", siteVisitCounter.getClass().getSimpleName());
            MultithreadingSiteVisitor multithreadingSiteVisitor = new MultithreadingSiteVisitor(siteVisitCounter);
            multithreadingSiteVisitor.visitMultithread(1000);
            multithreadingSiteVisitor.waitUntilAllVisited();
            System.out.printf("Total working time(s) : %.3f\n", multithreadingSiteVisitor.getTotalTimeOfHandling());
            System.out.println("Total counter : " + siteVisitCounter.getVisitCounter());
        }
    }
}