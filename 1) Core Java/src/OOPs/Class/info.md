
## Class
A class is a blueprint for creating objects, representing a group of properties and methods. It starts with a capital letter and is designed for creating custom data structures.

- **Class Name**: Always starts with a capital letter.
- **Purpose**: Acts as a template for objects.
- **Example**:
    ```java
    Student prasu; // Reference variable
    ```

### Types of Classes:
1. **Public Class**: A class that can be accessed from any other class in the program, regardless of the package they belong to.
  - **Example**:
    ```java
    public class Main {
    }
    ```

2. **Static Class**: A static class is a nested class (a class within another class) that can be accessed without creating an instance of the outer class, and it can only access static members of the outer class.
  - **Example**:
    ```java
    public class Main {
        static class Node { 
        }
    }
    ```

3. **Singleton Class**: A Singleton class in Java ensures that only one instance of the class is created and provides a global point of access to that instance.

   **Rules**:
  - The constructor is private to prevent instantiation from outside the class.
  - A static method provides the single instance of the class.
  - The instance is stored in a static variable.

  - **Example**:
    ```java
    public class Singleton {
        // Static variable to hold the single instance
        private static Singleton instance;

        // Private constructor to prevent instantiation
        private Singleton() {}

        // Static method to provide the single instance
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    ```

## Static Keyword
The `static` keyword is used to indicate that a member (variable, method, nested class) belongs to the class itself rather than instances of the class.

### Key Rules:
- Static fields (variables) are shared among all instances of the class.
- Static methods can be called without creating an instance of the class.
- Static blocks are used for static initialization of a class.
- Static nested classes can be accessed without an instance of the outer class.

  **Example**:
  ```java
  public class Main {
      static int a;

      static {
          a = 0;
          System.out.println("Will run once");
      }
  }
  ```

### Why is the main method static?
The `main` method is static because it can be used without creating an object. Without the `static` keyword, the JVM cannot run the program as it requires an instance to access non-static methods.

## Object
An object is an instance of a class. It is a reference type, meaning it holds the memory address of where the object is stored.

- **Reference Type**: Objects store references to their data in memory.
- **Example**:
    ```java
    prasu = new Student(); // prasu is now an object
    ```


## The `Object` Class in Java

The `Object` class is the root of the class hierarchy. Every class in Java is either a direct or indirect subclass of `Object`. It provides a set of fundamental methods that all Java objects inherit and can override.

### Key Methods of the `Object` Class that Can Be Overridden:

1. **hashCode()**
    - Returns a hash code value for the object, used in hashing-based collections like `HashMap`.

2. **equals(Object obj)**
    - Determines whether two object references are considered equal, based on custom logic that can be implemented.

3. **clone()**
    - Creates and returns a copy (clone) of the object, typically using shallow copying unless deep copying is implemented.

4. **finalize()**
    - Called by the garbage collector on an object when garbage collection determines that there are no more references to the object. It is rarely used and largely deprecated.

5. **toString()**
    - Returns a string representation of the object, typically overridden to provide meaningful information about the object.

---

## Other Important Methods in the `Object` Class:

1. **getClass()**
    - Returns the runtime class of the object (i.e., the class the object was instantiated from).
    - Methods of getClass: **[getName(), getSuperclass(), getInterfaces(), getDeclaredMethods(), getMethods(), getConstructors(), getFields(), getModifiers(), getPackage(), newInstance()]**
   ### Example:
   ```java
   public class Main {
       public static void main(String[] args) {
           Main obj = new Main();
           System.out.println("Class: " + obj.getClass().getName());
       }
   }
   // Output: Class: Main
   ```

2. **instanceof**
    - A keyword used to test whether an object is an instance of a specific class or implements a specific interface.

   ### Example:
   ```java
   public class Main {
       public static void main(String[] args) {
           String text = "Hello";
           if (text instanceof String) {
               System.out.println("text is an instance of String");
           }
       }
   }
   // Output: text is an instance of String
   ```

---

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

### Types of Constructors

1. **Default Constructor**:
    - A default constructor is provided by the compiler if no other constructor is defined. It doesn't take any parameters and simply initializes object members to default values.

    - **Example**:
      ```java
      class Student {
          String name;
          int age;
          
          // Default constructor
          public Student() {
              name = "Unknown";
              age = 0;
          }
      }
      ```

2. **Parameterized Constructor**:
    - A parameterized constructor accepts arguments, allowing custom values to be passed when an object is created.

    - **Example**:
      ```java
      class Student {
          String name;
          int age;
          
          // Parameterized constructor
          public Student(String name, int age) {
              this.name = name;
              this.age = age;
          }
      }
 
      Student prasu = new Student("Prasu", 20); // Calls the parameterized constructor
      ```

3. **Copy Constructor**:
    - A copy constructor creates a new object by copying the values from an existing object.

    - **Example**:
      ```java
      class Student {
          String name;
          int age;
          
          // Copy constructor
          public Student(Student s) {
              this.name = s.name;
              this.age = s.age;
          }
      }
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
