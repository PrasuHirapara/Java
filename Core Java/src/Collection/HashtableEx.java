package Collection;

import java.util.*;

public class HashtableEx {
    public static void main(String[] args) {
        // Create a Hashtable
        Hashtable<Integer, String> table = new Hashtable<>();

        // Add key-value pairs
        table.put(1, "Apple");
        table.put(2, "Banana");
        table.put(3, "Cherry");

        // Display the Hashtable
        System.out.println("Hashtable: " + table);

        // Retrieve a value
        String value = table.get(2);
        System.out.println("Value for key 2: " + value);

        // Check if a key is present
        boolean containsKey = table.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Check if a value is present
        boolean containsValue = table.containsValue("Apple");
        System.out.println("Contains value 'Apple': " + containsValue);

        // Remove a key-value pair
        table.remove(1);
        System.out.println("After removing key 1: " + table);

        // Use putIfAbsent
        table.putIfAbsent(4, "Date");
        System.out.println("After putIfAbsent: " + table);

        // Use replace
        table.replace(2, "Banana", "Blueberry");
        System.out.println("After replace: " + table);

        // Iterate over keys
        System.out.println("Keys: " + table.keySet());

        // Iterate over values
        System.out.println("Values: " + table.values());

        // Iterate over entries
        System.out.println("Entries: " + table.entrySet());

        // Get the size of the Hashtable
        int size = table.size();
        System.out.println("Size of Hashtable: " + size);

        // Clear the Hashtable
        table.clear();
        System.out.println("Hashtable after clearing: " + table);

        // Check if the Hashtable is empty
        boolean isEmpty = table.isEmpty();
        System.out.println("Is Hashtable Empty: " + isEmpty);
    }
}