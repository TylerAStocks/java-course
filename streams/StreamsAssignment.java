
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Item{     
    private int id;     
    private String name;     
    public Item(int id, String name){         
        this.id = id;         
        this.name = name;     
    }     
    public Integer getId() {         
        return id;     
    }      
    public void setId(int id) {         
        this.id = id;     
    }      
    public String getName() {         
        return name;     
    }      
    public void setName(String name) {         
        this.name = name;     
    }     
    public String toString(){    // outputs the name   
        return name;     
    } 
}

public class StreamsAssignment {

    public static void main(String[] args) {
        questionOne();
        questionTwo();
        questionThree();
    }

    public static void questionOne() {
        OptionalDouble avg = IntStream.of(0,1,2,3,4).average();
        System.out.println("" + avg.orElse(0.0));
    }
    
    public static void questionTwo() {
        Item i1 = new Item(1, "Screw");
        Item i2 = new Item(1, "Nail");
        Item i3 = new Item(1, "Bolt");

        List<Item> iList = Arrays.asList(i1, i2, i3);
        iList.stream()
                .sorted(Comparator.comparing(i -> i.getName()))
                .forEach(item -> System.out.print(item.getName()));
    }

    public static void questionThree() {
        Stream<List<String>> sList = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a","c"))
                                        .filter(s -> s.contains("c"));
        sList.flatMap(list -> list.stream())
            .forEach(System.out::println); 
    }

    public static void questionFour() {
        // a
        List<Integer> iList = Arrays.asList(1,2,3);
        // IntStream iStream = IntStream.of(iList);
                
    }

    public static void questionFive(int marks) {
        Optional<String> grade = "";
        if (marks > 50) {
            grade = Optional.of(“PASS”);
        } else {
            grade.of(“FAIL”);
        }
    }
}
