
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>(); // sorted by keys
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);
        System.out.println("" + map.containsKey("John")); // true
        System.out.println(""+ map.containsValue(18)); // true
        System.out.println(map.isEmpty()); //false
        System.out.println(""+map.get("John")); // 18
        for(String name:map.keySet()) {
            System.out.println(name); //Chris, John, Mary
        }

        for(Integer age:map.values()) { //sort is by keys
            System.out.println(age); //33, 18, 21
        }

        System.out.println("" + map.containsKey("Paul")); // false
        System.out.println("" + map.containsValue(21));
        System.out.println(map.size()); // 3
        map.clear();
        System.out.println(map.size()); // 0









        // forEach()
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);

        map.forEach((k, v) -> System.out.println( k + " maps to " + v));

        map.entrySet().forEach(entry ->
                    System.out.println(entry.getKey() + " -> " + entry.getValue()));


        Set keys = map.keySet(); // [Chris, John, Mary]
        //putIfAbsent()
        map.put("Mike", null);
        map.putIfAbsent("Chris", 99); // chris is unchanged since is present
        map.putIfAbsent("Mike", 55); //Mike is now 55 since age was null
        map.putIfAbsent("Luke", 31); // adds Luke to the map

        

    }
    
}
