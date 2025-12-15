package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private static AtomicInteger atomicCount = new AtomicInteger(0);
    
    // we will reach 10 now, however order is not guaranteed
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=1; i<=10; i++) {
            es.submit(() -> System.out.print(atomicCount.incrementAndGet() + " "));
        }

        es.shutdown();
    }
}
