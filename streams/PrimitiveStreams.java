
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        PrimitiveStreams ps = new PrimitiveStreams();
        // as opposed to Stream<T> we have streams for primitives
        // IntStream for int, short, byte, char
        // DoubleStream for double and float
        // LongStream for type long
        ps.creatingStream();
        ps.api();
        ps.stats(IntStream.of(5, 10, 15, 20));
        ps.stats(IntStream.empty());

        ps.functionalInterfaces();
        ps.mappingStreams();
    }


    public void creatingStream() {
        int[] ia = {1,2,3};
        double[] da = {1.1, 2.2, 3.3};
        long[] la = {1L, 2L, 3L};

        IntStream iStream1 = Arrays.stream(ia);
        DoubleStream dStream1 = Arrays.stream(da);
        LongStream lStream1 = Arrays.stream(la);

        System.out.println(iStream1.count() + ", " + dStream1.count() + ", " + lStream1.count()); //3, 3, 3

        IntStream iStream2 = IntStream.of(1,2,3);
        DoubleStream dStream2 = DoubleStream.of(1.1, 2.2, 3.3);
        LongStream lStream2 = LongStream.of(1L, 2L, 3L);

        System.out.println(iStream2.count() + ", " + dStream2.count() + ", " + lStream2.count()); //3, 3, 3


        // Using Stream<T> and reduce(identity, accumulator)
        Stream<Integer> numbers = Stream.of(1,2,3);
        System.out.println("" + numbers.reduce(0, (n1, n2) -> n1 + n2));


        // Using IntStream and sum()
        IntStream intS = Stream.of(1,2,3)
                                .mapToInt( n -> n);
        int total = intS.sum();
        System.out.println(total);

    }


    public void api() {
        System.out.println("API");
        OptionalInt max = IntStream.of(10, 20, 30)
                            .max(); //terminal operation
        max.ifPresent(System.out::println); // 30

        OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0)
                    .min(); // terminal
        
        System.out.println(min.orElseThrow()); // 10.0

        OptionalDouble average = LongStream.of(10L, 20L, 30L)
                        .average(); // terminal
        System.out.println(average.orElseGet(() -> Math.random())); //20.0
    }


    public void stats(IntStream numbers) {
        System.out.println("STATS");
        IntSummaryStatistics intStats = 
                    numbers.summaryStatistics(); // terminal op
        int min = intStats.getMin();
        System.out.println(min);
        int max = intStats.getMax();
        System.out.println(max);
        double avg = intStats.getAverage();
        System.out.println(avg);
        long count = intStats.getCount();
        System.out.println(count);
        long sum = intStats.getSum();
        System.out.println(sum);
    }

    public void functionalInterfaces() {
        // producers, consumers, biconsumers
    }

    public void mappingStreams() {
        System.out.println("MAPPING STREAMS");
        // mapping from same types is just map()
        // primitive to object is mapToObj()
        // to double is mapToDOuble()
        // to int is mapToInt()
        // to long is mapToLong()
    }
}
