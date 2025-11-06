
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        IntermediateOperations io = new IntermediateOperations();
        io.filterDistinctLimit();
        io.mapFlatMapSorted();
    }


    // unlike a terminal operation, an intermediate operation produces a stream as a result
    public void filterDistinctLimit() {
        System.out.println("FILTER");
        Stream.of("galway", "mayo", "roscommon")
            .filter(countyName -> countyName.length() > 5)
            .forEach(System.out::print);

        System.out.println("DISTINCT"); // returns stream with duplicate values removed, case sensitive
        Stream.of("eagle", "eagle", "EAGLE")
            .peek(s -> System.out.println(" 1."+s))
            .distinct()
            .forEach(s -> System.out.println(" 2." + s));

        System.out.println("LIMIT");
        Stream.of(11,22,33,44,55,66,77,88,99)
            .peek(n -> System.out.print(" A - "+n))
            .filter(n -> n > 40)
            .peek(n -> System.out.print(" B - "+n))
            .limit(2)
            .forEach(n -> System.out.print(" C - "+n));
        System.out.println();
    }

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }
    }


    public void mapFlatMapSorted() {
        // map() creates a one-to-one mapping between elements in the stream and elements in the next stage of the stream.
        // map() is for transforming data
        System.out.println("MAP");
        Stream.of("book", "pen", "ruler")
            .map(s -> s.length())
            .forEach(System.out::print);

        // flatMap() takes each element in the stream
        // e.g. Stream<List<String>> and makes any elements it contains
        // top-level elements in a single stream e.g. Stream<String>
        System.out.println("FLATMAP");
        List<String> list1 = Arrays.asList("sean", "desmond");
        List<String> list2 = Arrays.asList("marry", "ann");
        Stream<List<String>> streamOfLists = Stream.of(list1, list2);

        streamOfLists.flatMap(list -> list.stream())
            .forEach(System.out::print);
        

        System.out.println();
        // sorted() returns a stream with the elements sorted
        // needs to see all the data before it can sort it
        System.out.println("SORTED");
        Person john = new Person("John", 23);
        Person mary = new Person("Mary", 25);
        Stream.of(mary, john)
            .sorted(Comparator.comparing(p -> p.getAge()))
            .forEach(System.out::print);

        System.out.println("NO COMPARATOR");
        Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
            .peek(name -> System.out.print(" 0."+ name))
            .filter(name -> name.length() == 3)
            .peek(name -> System.out.print(" 1. "+name))
            .sorted()
            .peek(name -> System.out.print(" 2."+name))
            .limit(2)
            .forEach(name -> System.out.print(" 3." + name));

    }
}
