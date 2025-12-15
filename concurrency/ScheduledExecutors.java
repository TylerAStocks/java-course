package concurrency;

import java.util.concurrent.*;

public class ScheduledExecutors {
    private static ScheduledExecutorService schedES = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        schedule();
        scheduleWithFixedDelay();
        scheduleAtFixedRate();
    }

    public static void schedule() {
        System.out.println("Start...");
        Future<String> future = schedES.schedule(() -> "A", 2, TimeUnit.SECONDS);
        try {
            System.out.println(future.get()); // block
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            schedES.shutdown();
        }

        System.out.println("Always at the end!");
    }

    public static void scheduleWithFixedDelay() {
        System.out.println("Start...");
        final long INITIAL_DELAY = 2000, WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED=300;
        schedES.scheduleWithFixedDelay(() -> System.out.println("Thread id: "+Thread.currentThread().getId()),
         INITIAL_DELAY, WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED, TimeUnit.MILLISECONDS);
        // if I shut this down, nothing happens
    }

    public static void scheduleAtFixedRate() {
        System.out.println("Start...");
        final long INITIAL_DELAY= 2000, WAIT_PERIOD_BEFORE_STARTING_NEXT_TASK=300;
        schedES.scheduleAtFixedRate(() -> System.out.println("Thread id: "+Thread.currentThread().getId()),
         INITIAL_DELAY, WAIT_PERIOD_BEFORE_STARTING_NEXT_TASK, TimeUnit.MILLISECONDS);
        // if I shut this down, nothing happens
    }
}
