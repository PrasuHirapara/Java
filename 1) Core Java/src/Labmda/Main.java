package Labmda;

public class Main {
    public static void main(String[] args) {
        // Example 1: Lambda expression with no parameters
        Runnable noParam = () -> System.out.println("Result: No parameters");
        noParam.run(); // Output: No parameters

        // Example 2: Lambda expression with one parameter
        Greeting greetWithName = (name) -> System.out.println("Result: Hello, " + name);
        greetWithName.sayHello("John"); // Output: Hello, John

        // Example 3: Lambda expression with multiple parameters
        MathOperation add = (a, b) -> a + b;
        int result = add.operate(10, 20);
        System.out.println("Result: Sum is " + result); // Output: Sum is 30
    }

    // Functional interface for greeting
    @FunctionalInterface
    interface Greeting {
        void sayHello(String name);
    }

    // Functional interface for math operation
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
}
