
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


public class PredicateAndBiPredicate {
    public static void main(String[] args) {
        PredicateAndBiPredicate pnb = new PredicateAndBiPredicate();
        pnb.predicate();
        pnb.supplier();
        pnb.consumer();
        pnb.function();
        pnb.unaryAndBinary();
    }

    public void predicate() {
        // Predicate<T> is a functional interface, one abstract method

        Predicate<String> pStr = s -> s.contains("City");
        System.out.println("" + pStr.test("Vatican City")); // true

        // BiPredicate<T, U> is a functional interface, one abstract method
        // but now receives two params
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println("" + checkLength.test("Vatican City", 8)); // false, length is 12
        }

    private void supplier() {
        System.out.println("--- SUPPLIER ---");

        // Supplier<T> is a functional interface, one abstract method
        // T get()
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK")); // Supplier SB: SK

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get()); // current time

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get()); // some value
        
    }

    private void consumer() {
        System.out.println("--- CONSUMER ---");

        // Consumer<T> is a functional interface

        Consumer<String> printC = s -> System.out.println(s);
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
        mapCapitalCities.forEach(mapPrint);

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

    private void unaryAndBinary() {
        // T apply(T t)
        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Tyler"));

        // T apply(T 1, T t2)
        BinaryOperator<String> binaryOp = (s1, s2) -> s1.concat(s2);
        System.out.println("Binary Operator: "+ binaryOp.apply("Russell", "Crowe"));
    }

}
