
import java.util.ArrayList;
import java.util.Collection;


public class CommonCOllectionMethods {
    public static void main(String[] args) {
        // Lists allow duplicates
        Collection<String> col1 = new ArrayList<>();

        // asList() returns an unmodifiable collection
        // => add() throws an UnsupportedOperationException
        // Collection<String> col1 = Arrays.asLIst("Lucy", "April", "Lucy"); // <- immutable

        col1.add("Lucy");
        col1.add("April");
        col1.add("Lucy");
        System.out.println(col1); // [Lucy, April, Lucy]
        System.out.println("" + col1.remove("Lucy")); // true
        System.out.println(col1); //[April, Lucy]
        System.out.println(col1.isEmpty()); //false
        System.out.println(col1.size()); // 2
        System.out.println("" + col1.contains("John")); // false
        System.out.println("" + col1.contains("Lucy")); //true
        // removeIf(Predicate) and Predicate == boolean test(T t)
        System.out.println("" + col1.removeIf(s -> s.startsWith("A"))); // true
        col1.forEach(name -> System.out.println(name)); //[Lucy]
        col1.clear();
        col1.forEach(System.out::println); // nothing output

    }
}
