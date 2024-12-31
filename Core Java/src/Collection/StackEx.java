package Collection;

import java.util.*;

public class StackEx {
    public static void main(String[] args) {
        // Create a Stack of Integers
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        System.out.println("Initial Stack: " + stack);

        // Peek at the top element
        int topElement = stack.peek();
        System.out.println("Top Element: " + topElement);

        // Pop an element from the stack
        int poppedElement = stack.pop();
        System.out.println("Popped Element: " + poppedElement);
        System.out.println("Stack after pop: " + stack);

        // Check if the stack is empty
        boolean isEmpty = stack.empty();
        System.out.println("Is Stack Empty: " + isEmpty);

        // Search for an element in the stack
        int position = stack.search(10);
        System.out.println("Position of 10: " + position);

        // Use inherited methods
        stack.add(40); // Using Vector's add method
        System.out.println("Stack after using add: " + stack);

        stack.remove(1); // Using Vector's remove method
        System.out.println("Stack after using remove: " + stack);

        System.out.println("Size of Stack: " + stack.size());
    }
}