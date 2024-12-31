package Collection;

import java.util.*;

public class ArrayListEx {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Display the list
        System.out.println("Initial List: " + list);

        // Add an element at a specific index
        list.add(1, "Blueberry");
        System.out.println("After adding Blueberry: " + list);

        // Get an element by index
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit);

        // Set an element at a specific index
        list.set(2, "Citrus");
        System.out.println("After setting Citrus at index 2: " + list);

        // Remove an element by index
        list.remove(1);
        System.out.println("After removing element at index 1: " + list);

        // Check if the list contains an element
        boolean hasApple = list.contains("Apple");
        System.out.println("Contains Apple: " + hasApple);

        // Get the size of the list
        int size = list.size();
        System.out.println("Size of the list: " + size);

        // Clear the list
        list.clear();
        System.out.println("List after clearing: " + list);
    }
}