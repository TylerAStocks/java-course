
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
    String name = "";
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("John");

        int x=12; //final or effectively final

        // Lambdas take a snapchot of local variables; these local
        // variables MUST NOT change. Only setting up lambda here
        Predicate<String> lambda = s -> {
            // x++; <- no good, value must be final
            new LambdaEffectivelyFinal().name = "Keneddy";
            System.out.println("x == " +x);
            return s.isEmpty() && x%2 == 0;
        };
        filterData(a1, lambda);
        System.out.println(a1);

        //x++;

        new LambdaEffectivelyFinal().name = "Tyler"; // new instance, okay
        filterData(a1, lambda);

    }


    public static void filterData(List<String> list, Predicate<String> lambda) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            if(lambda.test(i.next())) {
                i.remove();
            }
        }
    }
}
