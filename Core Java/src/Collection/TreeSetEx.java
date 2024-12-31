package Collection;

import java.util.*;

public class TreeSetEx {
    public static void main(String[] args) {
        // Create a TreeSet of Integers
        TreeSet<Integer> set = new TreeSet<>();

        // Add elements to the TreeSet
        set.add(10);
        set.add(20);
        set.add(30);

        // Display the TreeSet
        System.out.println("TreeSet: " + set);

        // Check if an element is present
        boolean contains20 = set.contains(20);
        System.out.println("Contains 20: " + contains20);

        // Remove an element from the TreeSet
        set.remove(10);
        System.out.println("After removing 10: " + set);

        // Get the size of the TreeSet
        int size = set.size();
        System.out.println("Size of TreeSet: " + size);

        // Retrieve the first and last elements
        int first = set.first();
        int last = set.last();
        System.out.println("First Element: " + first);
        System.out.println("Last Element: " + last);

        // Find lower, higher, floor, and ceiling elements
        System.out.println("Lower than 30: " + set.lower(30));
        System.out.println("Higher than 20: " + set.higher(20));
        System.out.println("Floor of 25: " + set.floor(25));
        System.out.println("Ceiling of 15: " + set.ceiling(15));

        // Use subset, headset, and tailset methods
        System.out.println("Subset (20 to 40): " + set.subSet(20, 40));
        System.out.println("HeadSet (up to 30): " + set.headSet(30));
        System.out.println("TailSet (from 20): " + set.tailSet(20));

        // Clear the TreeSet
        set.clear();
        System.out.println("TreeSet after clearing: " + set);

        // Check if the TreeSet is empty
        boolean isEmpty = set.isEmpty();
        System.out.println("Is TreeSet Empty: " + isEmpty);
    }
}