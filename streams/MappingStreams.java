
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MappingStreams {
    public static void main(String[] args) {
        mappingObjectStreams();
        mappingPrimitiveStreams();
        
    }



    public static void mappingObjectStreams() {
        Stream.of("ash", "beech", "sycamore")
                    .map(tree -> tree.toUpperCase())
                    .forEach(System.out::println);
        DoubleStream dblStream = Stream.of("ash", "beech", "sycamore")
                                .mapToDouble(tree -> tree.length());
        dblStream.forEach(System.out::println);
        
        IntStream intStream = Stream.of("ash", "beech", "sycamore")
                    .mapToInt(tree -> tree.length());
        intStream.forEach(System.out::println);

        LongStream longStream = Stream.of("ash", "beech", "sycamore")
                    .mapToLong(tree -> tree.length());
        longStream.forEach(System.out::println);
    }


    public static void mappingPrimitiveStreams() {
        System.out.println("MAPPING PRIMITIVE STREAMS");

        Stream<String> streamAges = IntStream.of(1, 2, 3)
                        .mapToObj(n -> "Number: " + n);

        // forEach() is a terminal operation, stream CLOSES HERE
        // forEach(Consumer) - Consumer is a functional interface
        streamAges.forEach(System.out::println);
        
        DoubleStream dblStream = IntStream.of(1, 2, 3) // we must open the stream again
                        .mapToDouble(n -> (double)n); // cast is NOT necessary
        dblStream.forEach(System.out::println); // 1.0, 2.0, 3.0 

        //IntStream to IntStream
        IntStream.of(1, 2, 3)
            .map(n -> n*2)
            .forEach(System.out::println); // 2, 4, 6


        IntStream.of(1, 2, 3)
                .mapToLong(n -> (long)n) //just cast but it is NOT necessary
                .forEach(System.out::println);
    }
}
