package Collection;

import java.util.*;

public class LinkedHashSetEx {
    public static void main(String[] args) {
        // Create a LinkedHashSet of Strings
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // Add elements to the LinkedHashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // Display the LinkedHashSet
        System.out.println("LinkedHashSet: " + set);

        // Check if an element is present
        boolean containsApple = set.contains("Apple");
        System.out.println("Contains 'Apple': " + containsApple);

        // Remove an element from the LinkedHashSet
        set.remove("Banana");
        System.out.println("After removing 'Banana': " + set);

        // Get the size of the LinkedHashSet
        int size = set.size();
        System.out.println("Size of LinkedHashSet: " + size);

        // Add all elements from another collection
        List<String> additionalElements = Arrays.asList("Date", "Elderberry");
        set.addAll(additionalElements);
        System.out.println("After adding all elements from list: " + set);

        // Retain only specific elements
        set.retainAll(Collections.singleton("Apple"));
        System.out.println("After retaining only 'Apple': " + set);

        // Convert the LinkedHashSet to an array
        String[] array = set.toArray(new String[0]);
        System.out.println("LinkedHashSet as array: " + Arrays.toString(array));

        // Clear the LinkedHashSet
        set.clear();
        System.out.println("LinkedHashSet after clearing: " + set);

        // Check if the LinkedHashSet is empty
        boolean isEmpty = set.isEmpty();
        System.out.println("Is LinkedHashSet Empty: " + isEmpty);
    }
}