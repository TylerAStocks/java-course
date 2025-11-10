
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        searchStrings();
        searchCats();
    }


    public static void searchStrings() {
        List<String> names = Arrays.asList("John", "Martin", "Paula", "Ann");
        Collections.sort(names);
        System.out.println(names);
        System.out.println(Collections.binarySearch(names, "John"));
        System.out.println(Collections.binarySearch(names, "Laura"));
    }


    public static void searchCats() {
        Cat fluffy = new Cat("Fluffy", 1);
        Cat bella = new Cat("Bella", 5);
        List<Cat> catList = Arrays.asList(fluffy, bella);

        Collections.sort(catList);
        System.out.println(catList);

        System.out.println("Bella is at index: " + Collections.binarySearch(catList, bella));


        Comparator<Cat> byAge = (cat1, cat2) -> cat1.getAge() - cat2.getAge();
        Collections.sort(catList, byAge);
        System.out.println(catList);

        System.out.println("Bella is at index: " + Collections.binarySearch(catList, bella, byAge));
    }
    
}
