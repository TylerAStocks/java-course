
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class UsingQueues {
    public static void main(String[] args) {
        // linkedListQueue();
        // arrayDeque();
        // priorityQueueNaturalOrdering();
        priorityQueueDifferentOrdering();
    }


    public static void linkedListQueue() {
        Queue<Integer> queue = new LinkedList<>();
        // add() inserts into queue, throws exception if no space exists
        // offer() inserts into queue, returns false if no space exists
        queue.add(1); // Head -> [1]
        queue.offer(2); //Head -> [1,2]
        queue.add(3); //Head -> [1,2,3]
        queue.offer(4); //Head -> [1,2,3,4]

        // element() retrieves but does not remove the head of the queue, throws exception if empty
        // peek() retrieves but does not remove the head of the queue, returns null if empty

        System.out.println(queue.element()); //1
        System.out.println(queue.peek()); //1
        System.out.println(queue); // [1,2,3,4]


        //remove() - Retrieves and removes the head, throws exception if empty
        // poll - retrieves and removes the head, returns null if empty
        System.out.println(queue.remove()); //1
        System.out.println(queue.poll()); // 2
        System.out.println(queue); // [3,4]

        //offer()/poll() and peek() are preferred as they do not throw exceptions
    }


    public static void arrayDeque() {
        // Deque = "doubly ended queue". Supports element insertion/removal at both ends
        // ArrayDeque - resizeable-array implementation of the Deque interface (no capacity restrictions)

        Deque<Integer> numbers = new ArrayDeque<>();
        // "arg" (as in main(String []ARGS))
        // Deque methods that begin with "a", "r", or "g" e.g addFirst(), addLast()
        // removeFirst(), removeLast(), getFirst(), getLast() all throw exceptions if the deque is both
        // capacity-constrained and full
        // The other methods (POP): peekFirst(), peekLast(), offerFirst(), offerLast(), pollFirst(), pollLast()
        // all return null/false rather than throw an exception
        
        numbers.add(1); //Head -> [1] <- Tail
        numbers.addFirst(2); // Head -> [2,1] <- Tail
        numbers.offerFirst(3); //Head -> [3,1,2] <- Tail
        System.out.println("Head: " + numbers.getFirst() + ". Head: " + numbers.peekFirst()); // Head: 3. Head: 3
        // add at the end (Tail)
        numbers.addLast(4);
        numbers.offerLast(5);
        //remove from both ends
        numbers.removeFirst();
        numbers.pollFirst();
        numbers.removeLast();
        numbers.pollLast();
        System.out.println(numbers); // [1]

    }


    public static void priorityQueueNaturalOrdering() {
        Queue<String> names = new PriorityQueue<>();
        names.add("V");
        names.add("P");
        names.add("A");
        Iterator itNames = names.iterator();
        while(itNames.hasNext()) {
            System.out.print(names.poll() + " "); // A P V
        }

        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.add(11);
        numbers.add(5);
        numbers.add(2);
        Iterator itNumbers = numbers.iterator();
        while(itNumbers.hasNext()) {
            System.out.println(numbers.poll() + " "); // 2 5 11
        }
    }

    class Book {
        private String title;
        private Double price;
        Book(String title, Double price) {
            this.title = title;
            this.price = price;
        }
        public String getTitle() { return title; }
        public Double getPrice() { return price; }
        public String toString() { return "\t" + title + "\t" + price;}
    }


    public static void priorityQueueDifferentOrdering() {
        // Ordering specified by a comparator at construction time
        // 1. Order by the title of the book

        Comparator<Book> comparatorTitle = Comparator.comparing( book -> book.getTitle());
        Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle);
        booksByTitle.add(new Book("Java", 55.0));
        booksByTitle.add(new Book("Python", 23.0));
        booksByTitle.add(new Book("C++", 99.0));

        System.out.println("Ordering by title:");
        Iterator itBooks = booksByTitle.iterator();
        while(itBooks.hasNext()) {
            Book book = booksByTitle.poll();
            System.out.println(book);
        }

    }
    
}
