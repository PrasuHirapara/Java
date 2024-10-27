# Polymorphism
- **Poly** -> Many
- **Morphism** -> Ways to represent.

Polymorphism refers to the ability of an object to take many forms. Polymorphism is a core concept in object-oriented programming and is mainly implemented through **inheritance**.

It occurs during inheritance.

## Example:

```java
class Shapes {
    void area() {
        System.out.println("I am in Shape");
    }
}

public class Square extends Shapes {
    void area() {
        System.out.println("Area is square of side");
    }
    
    void area(float side) {
        System.out.println("Area is square of side " + side);
    }
}

public class Circles extends Shapes {
    void area() {
        System.out.println("Area is 3.14 * radius");
    }

    void area(float rad) {
        System.out.println("Area is square of side " + rad);
    }
}

public class Main {
    public static void main(String[] args) {
        Shapes shapes = new Shapes();
        Circles circles = new Circles();
        Square square = new Square();

        shapes.area();    // Output: I am in Shape
        circles.area();   // Output: Area is 3.14 * radius
        square.area(4);   // Output: Area is square of side 4
    }
}
```

### Output:
```
I am in Shape  
Area is 3.14 * radius  
Area is square of side 4
```

## Types of Polymorphism

### 1) **Compile-time or static polymorphism**
- Achieved by method overloading.
- Same method name, but different number of arguments, return type, type of argument, or order of arguments.
- Example:  
  In the `Square` class:
  ```java
  void area() {
     System.out.println("Area is square of side");
  }

  void area(float side) {
     System.out.println("Area is square of side " + side);
  }
  ```
  Here, the `area()` method is overloaded with different argument types (no argument vs. a `float` argument).

### 2) **Run-time or dynamic polymorphism**
- Achieved by method overriding.
- When a child class has a method with the same return type, number of arguments, order of arguments, and type of arguments but a different body.
- At runtime, **which method to call is determined by the object type**, and what it is able to access depends on reference type.
- Also known as **Late Binding.**
- To check if a method is overridden, use the `@Override` annotation.
- Example:  
  In the `Circles` class, the `area()` method overrides the `area()` method from the `Shapes` class:
  ```java
  @Override
  void area() {
     System.out.println("Area is 3.14 * radius");
  }
  ```
  Here, the `area()` method is overridden in the `Circles` class, and when called using a `Circles` object, it provides a different behavior than the `Shapes` class.

## Key Rules for Polymorphism

### a) Cannot override static methods
- **Reason**: Static methods do not depend on instances of an object. They are associated with the class itself and are resolved at compile time, making them unable to be overridden in the traditional sense. This allows static methods to maintain their behavior regardless of the object's state.

### Final Keyword
- **Prevents overriding**: The `final` keyword prevents method overriding and inheritance of classes.
- **Reason**: Overriding depends on object and static does not depend upon object. Hence, static method can not be overridden. 
- **Immutable values**: Variables declared as `final` cannot have their values changed once assigned.
- **Known as Early Binding**: Early binding refers to the process where the method to be called is resolved at compile-time, ensuring that the appropriate method is linked during compilation, thus preventing runtime changes.

```java
// Final class
final class Shape {
    void area() {
        System.out.println("I am in FinalShape");
    }
}

// Attempting to extend FinalShape will cause a compile-time error
/*
class Square extends Shape {
    void area() {
        System.out.println("Area is square of side");
    }
}
*/

// Final method
class Circle {
    final void area() {
        System.out.println("Area is 3.14 * radius");
    }
}

// Attempting to override a final method will cause a compile-time error
/*
class AdvancedCircle extends Circle {
    void area() {
        System.out.println("Overridden Area");
    }
}
*/

public class Main {
    public static void main(String[] args) {
        Shape Shape = new Shape();
        finalShape.area();  // Output: I am in FinalShape

        Circle circle = new Circle();
        circle.area();  // Output: Area is 3.14 * radius
    }
}
