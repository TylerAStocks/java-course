import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExercise {
    
    public static void main(String[] args) {
        CollectorsExercise ce = new CollectorsExercise();
        ce.numKey();
        ce.treeMap();
        ce.groupingByExample();
        ce.groupingByTreeMap();
        // in case of boolean, use partitioningBy()
    }



    public void numKey() {
        System.out.println("NUMKEY");
            Map<Integer, String> map =
            Stream.of("cake", "biscuits", "tart")
            .collect(
                Collectors.toMap(s -> s.length(), // key is the length
                                s -> s, // value is the String
                                (s1, s2) -> s1 + "," + s2) // Merge function -what to do if we have duplicate keys -append values
            );
        System.out.println(map);
    }


    public void treeMap() {
        System.out.println("TREEMAP");
        TreeMap<String, Integer> map = 
            Stream.of("cake", "biscuits", "apple tart", "cake")
            .collect(
                Collectors.toMap(s -> s,    // key is the String
                s -> s.length(),            // value is the length of the String
                (len1, len2) -> len1 + len2, // what to do if we have duplicate keys - add the values
                () -> new TreeMap<>() // TreeMap::new works
               )
            );

        System.out.println(map);
        System.out.println(map.getClass());
    }


    public void groupingByExample() {
        System.out.println("GROUPINGBYEXAMPLE");
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, List<String>> map =
            names.collect(
                // passing in a Function that determines the
                // key in the Map
                Collectors.groupingBy(String::length) // s-> s.length
            );
        System.out.println(map);
    }

    public void groupingByTreeMap() {
        System.out.println("Tree Map");
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        TreeMap<Integer, List<String>> map = 
            names.collect(
                Collectors.groupingBy(
                    String::length,
                    TreeMap::new,
                    Collectors.toList()
                )
            );

        System.out.println(map);
        System.out.println(map.getClass());
    }
}
