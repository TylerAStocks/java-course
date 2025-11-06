import java.util.Arrays;
import java.util.List;

public class LazyStreams {


    public static void main(String[] args) {

        List<String> names = Arrays.asList("April", "Ben", "Charlie", "David", "Benildus", "Christian");

        names.stream()
            .peek(System.out::println)
            .filter(s -> {
                System.out.println("filter1 : "+s);
                return s.startsWith("B") || s.startsWith("C"); } )
            .filter(s -> {
                System.out.println("filter2 : "+s);
                return s.length() > 3;
            })
            .limit(1) // intermediate operation
            .forEach(System.out::println); // terminal operation



        // Stream.of("Alex", "David", "April", "Edward")
/*             .filter(s -> {
                System.out.println("filter: "+s);
                return true;
            })
            .forEach(s -> System.out.println("forEach: "+s)); */
/*             .map(s -> {
                System.out.println("map: "+s);
                return s.toUpperCase();
            })
            .anyMatch(s -> {
                System.out.println("anyMatch: "+s);
                return s.startsWith("D");
            }); */
    } 

}