package OOPs.CollectionFrameWork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        // Using for-each loop (works because ArrayList implements Iterable)
        for (String name : names) {
            System.out.println(name);
        }

        Collection<String> names1 = new ArrayList<>();
        names1.add("A");
        names1.add("B");
        names1.add("C");

        // Iterating over the collection
        for (String name : names1) {
            System.out.println(name);
        }
        Vector<Integer> numbers = new Vector<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Iterating through Vector
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }
}
