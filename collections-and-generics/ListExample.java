
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ListExample {
    
    public static void main(String[] args) {
        arrayList();
        
    }

    public static void factoryMethods() {
        String[] array = new String[] {"Alpha", "Beta", "Charlie"};
        List<String> asList = Arrays.asList(array); // 'array' and 'asList' are now 'backed'
        List<String> of = List.of(array);
        List<String> copy = List.copyOf(asList);

        array[0] = "Delta"; //changes to the array 'write through' to the List
        System.out.println(Arrays.toString(array)); // [Delta, Beta, Charlie]
        System.out.println(asList); // [Delta, Beta, Charlie]

        asList.set(1, "Echo"); //changes to the list 'write through' to the array
        System.out.println(Arrays.toString(array)); // [Delta, Echo, Charlie]
        System.out.println(asList); // [Delta, Echo, Charlie]

        // of.add("Foxtrot") // UNsupportedOperationException
        // copy.add("Foxtrot") // UnsupportedOperationException
        // asList.add("Foxtrot") // UNsupportedOperationException
        
    }



    public static void arrayList() {
        List<String> list = new ArrayList<> ();
        list.add("Alan");
        list.add("Alan");
        list.add(1, "Sean");
        list.add("Mary");
        list.add("Mary");
        System.out.println(list); // [Alan, Sean, Alan, Mary, Mary]
        System.out.println("" + list.get(1)); // Sean

        list.remove(0); // results in [Sean, Alan, Mary, Mary]
        list.remove("Mary"); // only first Mary is removed
        System.out.println(list); // [Sean, Alan, Mary]
        list.set(0, "Jack"); // [Jack, Alan, Mary]

        // replaceAll(UnaryOperator<E> op) - UnaryOperator is a Function<T, T> where the input and ouptu are the same type
        list.replaceAll(name -> name +  " Kennedy");
        System.out.println(list); // [Jack Kennedy, Alan Kennedy, Mary Kennedy]
    }


    public static void stack() {
        // Stack is a LIFO structure (Last in First Out) -  we can manipulate one end only
        // Using the Stack type as the reference type so we get access to the push(), pop(), and peek() methods
        Stack<String> stack = new Stack<>();
        stack.push("Andrea");
        stack.push("Barbara");
        stack.push("Caroline");
        System.out.println(stack); //[Andrea, Barbara, Caroline]
        //
        //
        //                                                 ^^top
        System.out.println("Top of stack: " + stack.peek()); // Caroline
        System.out.println("Popped: " + stack.pop()); // Caroline - [Andrea, Barbara]
        stack.push("Helen"); // [Andrea, Barbara, Helen]
        System.out.println(stack); // [Andrea, Barabara, Helen]

    }

    public static void linkedList() {
        LinkedList<String> names = new LinkedList<>();
        names.add("Colin"); // [Colin]
        names.add("David"); // [Colin, David]
        names.addFirst("Brian"); //Brian, Colin, David
        names.addLast("Edward"); // Brian, Colin, David, Edward
        System.out.println(names);

        names.remove("David"); // [Brian, Colin, Edward]
        names.removeFirst(); // [Colin, Edward]
        names.removeLast(); // [Colin]
        System.out.println(names);
    }


}
