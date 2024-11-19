
# Generics
Generics allow you to create classes, interfaces, and methods with a placeholder for types, enabling type-safe data structures.
Works as template. 

## How It Works
Generics enable you to define a single method or class that works with different types, providing compile-time type safety and reducing the need for type casting.

## Syntax
The basic syntax for defining a generic class is:

```java
class ClassName<T> {
    // class body
}
```

## Relation with Compile-Time Type Erasure
Java uses a feature called type erasure to remove generic type information at runtime, replacing it with bounds or `Object` types. This allows for backward compatibility with non-generic code.

## Custom ArrayList Example
Here's a brief overview of how to create a custom `ArrayList` using generics:

```java
public class CustomArrayList <T> {
    private T[] array;
    private int index = 0;

    public CustomArrayList() {
        this.array = (T[]) new Object[10];
    }

    public void add(T element) {
        if (index == array.length) {
            return;
        }
        array[index++] = element;
    }

    public T remove() {
        if (index == 0) {
            return null;
        }
        return array[--index];
    }
}
```

## Type Casting in Generics
Type casting is the process of converting one data type into another. In generics, casting is required when type information is erased at runtime, and an object is treated as `Object`.

## Wildcards in Generics
Wildcards in Java generics are used to allow flexible method definitions when working with parameterized types. They prevent errors in certain situations where specific types are not known.

### Syntax
```java
class Example {
    public void method(List<?> list) {
        // works with any type of List
    }
}
```

### Example: Upper Bound Wildcards
```java
public void processList(List<? extends Number> list) {
    for (Number n : list) {
        System.out.println(n);
    }
}
```

### Example: Lower Bound Wildcards
```java
public void addIntegers(List<? super Integer> list) {
    list.add(5); // safe to add Integer or subclass
}
```
