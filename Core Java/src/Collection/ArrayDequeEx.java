package Collection;

import java.util.*;

public class ArrayDequeEx {
    public static void main(String[] args) {
        // Create an ArrayDeque of Strings
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Add elements to the ArrayDeque
        deque.addFirst("Element1");
        deque.addLast("Element2");
        deque.addFirst("Element3");
        deque.addLast("Element4");

        // Display the ArrayDeque
        System.out.println("ArrayDeque: " + deque);

        // Retrieve elements from both ends
        String first = deque.getFirst();
        String last = deque.getLast();
        System.out.println("First Element: " + first);
        System.out.println("Last Element: " + last);

        // Remove elements from both ends
        String removedFirst = deque.pollFirst();
        String removedLast = deque.pollLast();
        System.out.println("Removed First Element: " + removedFirst);
        System.out.println("Removed Last Element: " + removedLast);

        // Check if an element is present
        boolean contains = deque.contains("Element2");
        System.out.println("Contains 'Element2': " + contains);

        // Iterate over the elements
        System.out.println("Iterating over ArrayDeque:");
        for (String element : deque) {
            System.out.println(element);
        }

        // Use offer to add elements
        deque.offerFirst("NewElement1");
        deque.offerLast("NewElement2");
        System.out.println("ArrayDeque after offers: " + deque);

        // Convert ArrayDeque to an array
        Object[] array = deque.toArray();
        System.out.println("Array representation: " + Arrays.toString(array));

        // Get the size of the ArrayDeque
        int size = deque.size();
        System.out.println("Size of ArrayDeque: " + size);

        // Clear the ArrayDeque
        deque.clear();
        System.out.println("ArrayDeque after clearing: " + deque);

        // Check if the ArrayDeque is empty
        boolean isEmpty = deque.isEmpty();
        System.out.println("Is ArrayDeque Empty: " + isEmpty);
    }
}