package Collection;

import java.util.*;

public class HashMapEx {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Add key-value pairs to the HashMap
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Display the HashMap
        System.out.println("HashMap: " + map);

        // Retrieve a value
        String value = map.get(2);
        System.out.println("Value for key 2: " + value);

        // Check if a key is present
        boolean containsKey = map.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Check if a value is present
        boolean containsValue = map.containsValue("Apple");
        System.out.println("Contains value 'Apple': " + containsValue);

        // Remove a key-value pair
        map.remove(1);
        System.out.println("After removing key 1: " + map);

        // Use putIfAbsent
        map.putIfAbsent(4, "Date");
        System.out.println("After putIfAbsent: " + map);

        // Use computeIfAbsent
        map.computeIfAbsent(5, key -> "Elderberry");
        System.out.println("After computeIfAbsent: " + map);

        // Use computeIfPresent
        map.computeIfPresent(2, (key, val) -> val + " Updated");
        System.out.println("After computeIfPresent: " + map);

        // Use compute
        map.compute(3, (key, val) -> val == null ? "Fig" : val + " Updated");
        System.out.println("After compute: " + map);

        // Use merge
        map.merge(3, "Grape", (oldVal, newVal) -> oldVal + ", " + newVal);
        System.out.println("After merge: " + map);

        // Get the size of the HashMap
        int size = map.size();
        System.out.println("Size of HashMap: " + size);

        // Iterate over the keys
        System.out.println("Keys: " + map.keySet());

        // Iterate over the values
        System.out.println("Values: " + map.values());

        // Iterate over the key-value pairs
        System.out.println("Entries: " + map.entrySet());

        // Clear the HashMap
        map.clear();
        System.out.println("HashMap after clearing: " + map);

        // Check if the HashMap is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is HashMap Empty: " + isEmpty);
    }
}