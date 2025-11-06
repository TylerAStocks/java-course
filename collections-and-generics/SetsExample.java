
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class SetsExample {
    public static void main(String[] args) {
        // factoryMethods();
        treeSet();
        hashSet();
        linkedHashSet();
    }

    private static class Contact {

        private String name;
        private int age;

        public Contact(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 89 * hash + this.age;
            hash = 89 * hash + this.name.length();
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Contact) {
                Contact otherContact = (Contact) obj;
                return (this.name.equals(otherContact.name) && this.age === otherContact.age);
            }

            return false;
        }
    }



    public static void factoryMethods() {
        // unmodifiable sets returned
        Set<String> of = Set.of("a", "b", "c");
        Set<String> copy = Set.copyOf(of);

        // of.add("d"); //UnsupportedOperationException
        // copy.add("d"); // UnsupportedOperationException

        // of.remove("a"); //UNsupportedOperationException


    }



    public static void treeSet() {
        Set<String> names = new TreeSet<>();
        names.add("John");
        names.add("John");
        names.add("Helen");
        names.add("Anne");
        // No duplicates. elements are sorted alphabetically
        System.out.println(names); //[Anne, Helen, John]

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(23);
        numbers.add(Integer.valueOf("21"));
        numbers.add(Integer.valueOf("11"));
        numbers.add(99);
        // nu duplicates, elements are sorted numerically
        System.out.println(numbers); // [11, 21, 23, 99]

    }


    public static void hashSet() {
        // HashSet
        Set<Contact> contactHS = new HashSet<>();
        contactHS.add(new Contact("zoe", 45));
        contactHS.add(new Contact("zoe", 45));
        contactHS.add(new Contact("alice", 34));
        contactHS.add(new Contact("andrew", 35));
        contactHS.add(new Contact("brian", 36));
        contactHS.add(new Contact("carol", 37));

        for(Contact contact:contactHS) {
            System.out.println(contact);
        }
        System.out.println();
    }


    public static void linkedHashSet() {
        Set<Contact> contactsLHS = new LinkedHashSet();
        contactsLHS.add(new Contact("zoe", 45));
        contactsLHS.add(new Contact("zoe", 45));
        contactsLHS.add(new Contact("alice", 34));
        contactsLHS.add(new Contact("andrew", 35));
        contactsLHS.add(new Contact("brian", 36));
        contactsLHS.add(new Contact("carol", 37));

        for(Contact contact:contactsLHS) {
            System.out.println(contact);
        }
    }


}