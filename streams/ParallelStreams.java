import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum == "+sum);
    }
    
}
