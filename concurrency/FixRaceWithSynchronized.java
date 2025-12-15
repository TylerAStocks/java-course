package concurrency;

public class FixRaceWithSynchronized {

    private static int count = 0;

    public synchronized static void addToCounter() {

        int c = count;
        System.out.println("Before. "+count + ". Thread id: "+ Thread.currentThread().getId());
        count = c + 1; // not atomic
        System.out.println("After. "+count+". Thread id: "+ Thread.currentThread().getId());
    }

    // in this example, we reach 10 and the results are in order
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            new Thread(() -> addToCounter()).start();
        }
    }
    
}
