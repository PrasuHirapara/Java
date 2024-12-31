package Collection;

import java.util.*;

public class VectorEx {
    public static void main(String[] args) {
        // Create a Vector of Strings
        Vector<String> vector = new Vector<>();

        // Add elements to the vector
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Display the vector
        System.out.println("Initial Vector: " + vector);

        // Add an element at a specific index
        vector.add(1, "Blueberry");
        System.out.println("After adding Blueberry: " + vector);

        // Get an element by index
        String fruit = vector.get(2);
        System.out.println("Element at index 2: " + fruit);

        // Set an element at a specific index
        vector.set(2, "Citrus");
        System.out.println("After setting Citrus at index 2: " + vector);

        // Remove an element by index
        vector.remove(1);
        System.out.println("After removing element at index 1: " + vector);

        // Check if the vector contains an element
        boolean hasApple = vector.contains("Apple");
        System.out.println("Contains Apple: " + hasApple);

        // Get the first and last elements
        System.out.println("First Element: " + vector.firstElement());
        System.out.println("Last Element: " + vector.lastElement());

        // Get the size of the vector
        int size = vector.size();
        System.out.println("Size of the vector: " + size);

        // Clear the vector
        vector.clear();
        System.out.println("Vector after clearing: " + vector);
    }
}