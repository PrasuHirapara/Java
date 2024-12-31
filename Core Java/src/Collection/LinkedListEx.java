package Collection;

import java.util.*;

public class LinkedListEx {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Display the list
        System.out.println("Initial List: " + list);

        // Add an element at a specific index
        list.add(1, "Blueberry");
        System.out.println("After adding Blueberry: " + list);

        // Add an element at the beginning and end
        list.addFirst("Mango");
        list.addLast("Pineapple");
        System.out.println("After adding Mango and Pineapple: " + list);

        // Get an element by index
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit);

        // Get the first and last elements
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        // Remove an element by index
        list.remove(1);
        System.out.println("After removing element at index 1: " + list);

        // Remove the first and last elements
        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first and last elements: " + list);

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