import java.util.ArrayList;
import java.util.List;


public class PolymorphicIssueWithGenerics {

    public static void showList(List<Object> list) {
        for(Object o:list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(12.3);
        List<Object> objects = doubles; // COMPILER ERROR
        objects.add("This is a String");

        // a different variation
        List<String> names = new ArrayList<String>();
        names.add("Sean");
        showList(names); // List<Object> list = new ArrayList<String>();
    }
    
}
