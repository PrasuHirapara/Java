## Class
A class is a blueprint for creating objects, representing a group of properties and methods. It starts with a capital letter and is designed for creating custom data structures.

- **Class Name**: Always starts with a capital letter.
- **Purpose**: Acts as a template for objects.
- **Example**:
    ```java
    Student prasu; // Student is the class
    ```

## Object
An object is an instance of a class. It is a reference type, meaning it holds the memory address of where the object is stored.

- **Reference Type**: Objects store references to their data in memory.
- **Example**:
    ```java
    prasu = new Student(); // prasu is now an object
    ```

## `new` Keyword
The `new` keyword dynamically allocates memory for an object and returns a reference to it.

- **Example**:
    ```java
    prasu = new Student(); // Dynamically allocates memory for the Student object
    ```

## Class Declaration vs. Object Creation
- **Class Declaration**: Done at compile-time.
    ```java
    Student prasu; // Declares a variable of type Student
    ```
- **Object Creation**: Done at runtime using the `new` keyword.
    ```java
    prasu = new Student(); // Allocates memory and creates the object at runtime
    ```

## Instance Variables
Instance variables are properties defined inside objects of a class. They can be accessed or modified through the object reference.

- **Accessing**:
    ```java
    prasu.name; // Access if 'name' is public
    ```
- **Updating**:
    ```java
    prasu.name = "Prasu"; // Update if 'name' is public
    ```

## Constructor
A constructor is a special function that gets called when an object is created. Its name is always the same as the class name.

- **Example**:
    ```java
    public Student(String name) {
        this.name = name;
    }
    prasu = new Student("Prasu"); // Calls the constructor when creating the object
    ```

## `this` Keyword
The `this` keyword refers to the current instance of the object and is often used to resolve naming conflicts between instance variables and parameters.

- **Example**:
    ```java
    public Student(String name) {
        this.name = name; // 'this' refers to the current instance
    }
    ```

## Wrapper Class
Wrapper classes are built-in Java classes that help convert primitive data types to objects and vice versa. They also provide additional methods for operations on the values.

- **Example**:
    ```java
    Integer a = Integer.valueOf("10"); // Wrapper class for int
    ```

## Garbage Collection
Java automatically removes objects from memory when they are no longer needed. This process can also be triggered manually using the `finalize()` method.

- **Example**:
    ```java
    @Override
    public void finalize() throws Throwable {
        // Cleanup code before garbage collection
    }
    ```
