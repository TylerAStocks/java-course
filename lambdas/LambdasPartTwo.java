import java.util.ArrayList;
import java.util.List;

public class LambdasPartTwo {
    public static void main(String[] args) {
        var listPeople = getPeople();
        sortAge(listPeople);
    }


    private static List<Person> sortAge(List<Person> people) {

    }


     private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private static class Person {

        public Person() {
        }

        private Person(String name, int age, double height) {
            
        }
    }


}
