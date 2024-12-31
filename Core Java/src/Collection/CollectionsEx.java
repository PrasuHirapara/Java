package Collection;

import java.util.*;

public class CollectionsEx {
    public static void main(String[] args) {
        // Create and initialize a list
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 6, 1, 9, 3));

        // Print original list
        System.out.println("Original List: " + numbers);

        // Sort the list
        Collections.sort(numbers);
        System.out.println("Sorted List: " + numbers);

        // Reverse the list
        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers);

        // Shuffle the list
        Collections.shuffle(numbers);
        System.out.println("Shuffled List: " + numbers);

        // Find the maximum and minimum element
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Max Element: " + max);
        System.out.println("Min Element: " + min);

        // Frequency of an element
        int freq = Collections.frequency(numbers, 5);
        System.out.println("Frequency of 5: " + freq);

        // Replace all occurrences of an element
        Collections.replaceAll(numbers, 5, 50);
        System.out.println("List after replacing 5 with 50: " + numbers);

        // Rotate the list by 3 positions
        Collections.rotate(numbers, 3);
        System.out.println("List after rotation: " + numbers);

        // Swap elements at two positions
        Collections.swap(numbers, 0, numbers.size() - 1);
        System.out.println("List after swapping first and last elements: " + numbers);

        // Copy a list (requires the destination list to be of the same size)
        List<Integer> copy = new ArrayList<>(Collections.nCopies(numbers.size(), 0));
        Collections.copy(copy, numbers);
        System.out.println("Copied List: " + copy);

        // Unmodifiable list
        List<Integer> unmodifiableList = Collections.unmodifiableList(numbers);
        System.out.println("Unmodifiable List: " + unmodifiableList);

        // Attempting to modify the unmodifiable list will throw an exception
        try {
            unmodifiableList.add(100);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify unmodifiable list.");
        }
    }
}
