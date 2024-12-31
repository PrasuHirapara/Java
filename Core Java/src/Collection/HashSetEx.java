package Collection;

import java.util.*;

public class HashSetEx {
    public static void main(String[] args) {
        // Create a HashSet of Strings
        HashSet<String> set = new HashSet<>();

        // Add elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // Display the HashSet
        System.out.println("HashSet: " + set);

        // Check if an element is present
        boolean containsApple = set.contains("Apple");
        System.out.println("Contains 'Apple': " + containsApple);

        // Remove an element from the HashSet
        set.remove("Banana");
        System.out.println("After removing 'Banana': " + set);

        // Get the size of the HashSet
        int size = set.size();
        System.out.println("Size of HashSet: " + size);

        // Add all elements from another collection
        List<String> additionalElements = Arrays.asList("Date", "Elderberry");
        set.addAll(additionalElements);
        System.out.println("After adding all elements from list: " + set);

        // Retain only specific elements
        set.retainAll(Collections.singleton("Apple"));
        System.out.println("After retaining only 'Apple': " + set);

        // Convert the HashSet to an array
        String[] array = set.toArray(new String[0]);
        System.out.println("HashSet as array: " + Arrays.toString(array));

        // Check if the HashSet is empty
        boolean isEmpty = set.isEmpty();
        System.out.println("Is HashSet Empty: " + isEmpty);

        // Clear the HashSet
        set.clear();
        System.out.println("HashSet after clearing: " + set);
    }
}