package Collection;

import java.util.*;

public class PriorityQueueEx {
    public static void main(String[] args) {
        // Create a PriorityQueue of Integers
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the PriorityQueue
        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(40);

        // Display the PriorityQueue (natural ordering)
        System.out.println("PriorityQueue: " + pq);

        // Retrieve the head element
        int head = pq.peek();
        System.out.println("Head Element: " + head);

        // Remove the head element
        int removed = pq.poll();
        System.out.println("Removed Element: " + removed);
        System.out.println("PriorityQueue after poll: " + pq);

        // Check if an element is present
        boolean contains = pq.contains(20);
        System.out.println("Contains 20: " + contains);

        // Iterate over the elements
        System.out.println("Iterating over PriorityQueue:");
        for (Integer element : pq) {
            System.out.println(element);
        }

        // Use offer to add an element
        pq.offer(25);
        System.out.println("PriorityQueue after offer: " + pq);

        // Convert PriorityQueue to an array
        Object[] array = pq.toArray();
        System.out.println("Array representation: " + Arrays.toString(array));

        // Get the size of the PriorityQueue
        int size = pq.size();
        System.out.println("Size of PriorityQueue: " + size);

        // Clear the PriorityQueue
        pq.clear();
        System.out.println("PriorityQueue after clearing: " + pq);

        // Check if the PriorityQueue is empty
        boolean isEmpty = pq.isEmpty();
        System.out.println("Is PriorityQueue Empty: " + isEmpty);
    }
}