package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {
    public static void main(String[] args) {
        // Easy Example
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultEasy = list.stream()
                .filter(x -> x % 2 == 0)         // Filter even numbers
                .map(x -> x * 2)                 // Double each number
                .distinct()                      // Remove duplicates
                .sorted()                        // Sort the list
                .limit(5)                        // Take the first 5
                .peek(System.out::println)       // Print each element
                .collect(Collectors.toList());
        System.out.println("Easy Result: " + resultEasy);

        System.out.println();

        // Medium Example
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alice", "David", "Eve", "Frank", "Eve");
        List<String> resultMedium = names.stream()
                .filter(name -> name.length() > 3)   // Filter names longer than 3 characters
                .map(String::toUpperCase)            // Convert to uppercase
                .distinct()                          // Remove duplicates
                .sorted()                            // Sort alphabetically
                .skip(1)                             // Skip the first element
                .peek(System.out::println)           // Print each element
                .collect(Collectors.toList());
        System.out.println("Medium Result: " + resultMedium);

        System.out.println();

        // Hard Example
        List<Double> numbers = Stream.iterate(1.0, x -> x + 1).limit(20).collect(Collectors.toList());
        double hardResult = numbers.parallelStream()
                .filter(x -> x > 5)                      // Filter numbers greater than 5
                .map(x -> Math.pow(x, 2))                // Square each number
                .distinct()                              // Remove duplicates
                .sorted((a, b) -> b.compareTo(a))        // Sort in descending order
                .skip(3)                                 // Skip the first 3 elements
                .peek(System.out::println)               // Print each element
                .limit(5)                                // Take the first 5
                .mapToDouble(Double::doubleValue)        // Convert to double
                .sum();                                  // Sum the remaining numbers
        System.out.println("Hard Result (Sum): " + hardResult);
    }
}
