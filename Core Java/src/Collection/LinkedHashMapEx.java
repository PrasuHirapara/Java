package Collection;

import java.util.*;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        // Create a LinkedHashMap
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();

        // Add key-value pairs to the LinkedHashMap
        linkedMap.put(1, "Apple");
        linkedMap.put(2, "Banana");
        linkedMap.put(3, "Cherry");

        // Display the LinkedHashMap
        System.out.println("LinkedHashMap: " + linkedMap);

        // Retrieve a value
        String value = linkedMap.get(2);
        System.out.println("Value for key 2: " + value);

        // Check if a key is present
        boolean containsKey = linkedMap.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Check if a value is present
        boolean containsValue = linkedMap.containsValue("Apple");
        System.out.println("Contains value 'Apple': " + containsValue);

        // Remove a key-value pair
        linkedMap.remove(1);
        System.out.println("After removing key 1: " + linkedMap);

        // Use putIfAbsent
        linkedMap.putIfAbsent(4, "Date");
        System.out.println("After putIfAbsent: " + linkedMap);

        // Use computeIfAbsent
        linkedMap.computeIfAbsent(5, key -> "Elderberry");
        System.out.println("After computeIfAbsent: " + linkedMap);

        // Use computeIfPresent
        linkedMap.computeIfPresent(2, (key, val) -> val + " Updated");
        System.out.println("After computeIfPresent: " + linkedMap);

        // Use compute
        linkedMap.compute(3, (key, val) -> val == null ? "Fig" : val + " Updated");
        System.out.println("After compute: " + linkedMap);

        // Use merge
        linkedMap.merge(3, "Grape", (oldVal, newVal) -> oldVal + ", " + newVal);
        System.out.println("After merge: " + linkedMap);

        // Iterate over the keys
        System.out.println("Keys: " + linkedMap.keySet());

        // Iterate over the values
        System.out.println("Values: " + linkedMap.values());

        // Iterate over the key-value pairs
        System.out.println("Entries: " + linkedMap.entrySet());

        // Check if the LinkedHashMap is empty
        boolean isEmpty = linkedMap.isEmpty();
        System.out.println("Is LinkedHashMap Empty: " + isEmpty);
    }
}