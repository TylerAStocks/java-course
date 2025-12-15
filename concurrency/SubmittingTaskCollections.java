package concurrency;

import java.util.*;
import java.util.concurrent.*;

public class SubmittingTaskCollections {
    // Single Thread Executors will accept tasks sequentially in the order
    // they are submitted
    private static ExecutorService es = Executors.newSingleThreadExecutor();
    // with 4 threads to share the work, there is no guarantee which letter
    // will appear first

    private static List<Callable<String>> callables = new ArrayList<>();

    public static void main(String[] args) {
        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");

        invokeAny();
    }


    public static void invokeAny() {
        try {
            // submitting a collection of tasks
            // executes synchronously and returns whe  one of the tasks has completed, all
            // other tasks are cancelled
            // Note: Single thread executor will always execute the first task submitted

            String result = es.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // don't forget to shutdown the executor
            // finally always executes
            es.shutdown();
        }

        System.out.println("Always at the end!");

    }
}
