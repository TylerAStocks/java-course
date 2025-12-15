package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.offer("Red");
        queue.offer("Green");
        queue.offer("Blue");

        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);

        try {
            queue.offer("White", 100, TimeUnit.MILLISECONDS);
            queue.poll(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue);
    }
    
}
