package Collection;

import java.util.*;

public class TreeMapEx {
    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<Integer, String> map = new TreeMap<>();

        // Add key-value pairs to the TreeMap
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Display the TreeMap
        System.out.println("TreeMap: " + map);

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

        // Get first and last keys
        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());

        // Use ceilingKey, floorKey, higherKey, and lowerKey
        System.out.println("Ceiling Key (2): " + map.ceilingKey(2));
        System.out.println("Floor Key (2): " + map.floorKey(2));
        System.out.println("Higher Key (2): " + map.higherKey(2));
        System.out.println("Lower Key (2): " + map.lowerKey(2));

        // Iterate over the keys
        System.out.println("Keys: " + map.keySet());

        // Iterate over the values
        System.out.println("Values: " + map.values());

        // Iterate over the key-value pairs
        System.out.println("Entries: " + map.entrySet());

        // Clear the TreeMap
        map.clear();
        System.out.println("TreeMap after clearing: " + map);

        // Check if the TreeMap is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is TreeMap Empty: " + isEmpty);
    }
}