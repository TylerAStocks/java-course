package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        

        // submit the Callable task to the executor service
        // and store the Future object
        Future<Integer> future = es.submit(() -> 3 + 5);

        try {
            System.out.println("The answer is: "+ future.get(500, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }


        es.shutdown();
    }
}
