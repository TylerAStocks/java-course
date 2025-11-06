
import java.time.LocalTime;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;



interface Printable<T> {
    void print (T t);
}

interface Retrievable<T> {
    T get (T t);
}

interface Evaluate<T> {
    boolean isNegative (T t);
}
 
public class BasicLambdas {
    public static void main(String[] args) {
        BasicLambdas bl = new BasicLambdas();
        bl.consumer();
        bl.supplier();
        bl.predicate();
        bl.function();
    }


    private void function() {
        System.out.println("--- FUNCTION and BIFUNCTION ---");
        // R apply(T t)
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("MOscow")); // 6

        // BiFunction<T, U, R>
        // R apply(T t, U u)
        BiFunction<String, String, Integer> biFn = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction "+biFn.apply("William", "Shakespeare")); // 18

        BiFunction<String, String, String> biFn2 = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFUnction: " + biFn2.apply("Willie", "Nelson")); //Willie Nelson

    }

    private void predicate() {
        // 3A
        Evaluate<Integer> lambda = i -> i < 0;

        System.out.println("Evaluate: " + lambda.isNegative(-1)); //true
        System.out.println("Evaluate: " + lambda.isNegative(+1)); //false

        // 3B
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1)); //true
        System.out.println("Predicate: " + predicate.test(+1)); // false

        // 3C
        int x = 4;
        System.out.println("CHECK METHOD:");
        System.out.println("is " + x+ " even? " + check(x, n -> n % 2 == 0)); // true
        x = 7;
        System.out.println("is " + x+ " even? " + check(x, n -> n % 2 == 0)); // false

        // because of generic typing, lambda accepts both ints and strings
        String name="Mr. Joe Bloggs";
        System.out.println("Does " +name+ " start with Mr. ?" +
            check(name, s -> s.startsWith("Mr."))); //true
        name="Mrs. Ann Bloggs";
        System.out.println("Does " +name+ " start with Mr. ?" +
            check(name, s -> s.startsWith("Mr."))); // false
        
    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }


    private void supplier() {
        // T get()

/*         //2A
        Retrievable<Integer> getNumber = () -> 77;
        System.out.println(getNumber.get());

        //2B
        Supplier<Integer> numL = () -> 77; */




        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK")); // Supplier SB: SK

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get()); // current time

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get()); // some value
        
    }


    private void consumer() {
        // Consumer<T> is a functional interface


        // 1A
        Printable<String> printP = (s) -> System.out.println(s);
        printP.print("Printable lambda");
        //1B
        Consumer<String> printCon = s -> System.out.println(s);
        Consumer<String> printMR = System.out::println;

        printCon.accept("Printable lambda");
        printMR.accept("Printable Method Reference");



/*         Consumer<String> printC = s -> System.out.println(s);
        printC.accept("To be or not to be");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printC);


        //BiConsumer<T, U>
        // void accept(T t, U u)
        var mapCapitalCities = new HashMap<String, String>();
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington DC", "USA");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the capital of " + value);
        mapCapitalCities.forEach(mapPrint); */

    }

}
