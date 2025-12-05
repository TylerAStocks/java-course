
import java.util.List;
import java.util.ArrayList;

public class PreGenerics {

    public static void main(String [] args) {
        // a raw collection can hold any type of Object (except a primitive)
        List myList = new ArrayList();
        myList.add("Fred");
        myList.add(new Dog());
        myList.add(43);

        // as everything is treated as an Object, when you are getting something out og
        // the collection, all you have are Objects - therefore a cast was require to get your String back

        String s = (String)myList.get(0); // cast required else compiler error

        // and as we could not guarantee that what was coming out
        // was really a String (as we were allowed to put anything in),
        // this cast could fail at runtime
        String s1 = (String)myList.get(1); // ClassException at runtime


        // Generics takes care of both ends (putting in and getting out)
        // by enforcing the type of your collections
        // Note: generic syntax means putting the type in angle brackets

        List<String> myList2 = new ArrayList<String>();
        myList.add("Fred"); // will hold Strings
        myList.add(new Dog()); // compiler error

        // Because what is going In is guaranteed, what is coming OUT is
        // also guaranteed => no need for the cast
        String s2 = myList2.get(0); // cast no longer required
    }
    
}
