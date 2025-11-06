import java.util.function.Predicate;

interface Evaluate<T> {
    boolean isNegative (T t);
}


public class FunctionalInterface {
    
    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;

        System.out.println("Evaluate: " + lambda.isNegative(-1)); //true
        System.out.println("Evaluate: " + lambda.isNegative(+1)); //false

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1)); //true
        System.out.println("Predicate: " + predicate.test(+1)); // false


        // check method test
        int x = 4;
        System.out.println("CHECK METHOD:");
        System.out.println("is " + x+ " even? " + check(x, n -> n % 2 == 0)); // true
        x = 7;
        System.out.println("is " + x+ " even? " + check(x, n -> n % 2 == 0)); // false

        // because of generic typing, lambda accepts both ints and strings
        String name="Mr. Joe Biden";
        System.out.println("Does " +name+ " start with Mr. ?" +
            check(name, s -> s.startsWith("Mr."))); //true
        name="Mrs. Joe Biden";
        System.out.println("Does " +name+ " start with Mr. ?" +
            check(name, s -> s.startsWith("Mr."))); // false

    }

    // lambda definition is passed as second argument of this method
    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}
