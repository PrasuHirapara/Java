# Java Collection Framework

The Java Collection Framework provides a set of classes and interfaces to store and manipulate groups of objects in Java. It is one of the most essential parts of the Java API.

![Java Collection Framework](https://static.wixstatic.com/media/4e14eb_aca803970e404af1becaf47f0ea491e0~mv2.jpg/v1/fill/w_875,h_500,al_c,lg_1,q_85,enc_auto/4e14eb_aca803970e404af1becaf47f0ea491e0~mv2.jpg)

## Interfaces and Their Use Cases

- **Collection**: The root interface representing a group of objects, known as elements. It supports methods like `add`, `remove`, and iteration over the collection.
    - Use case: Provides a common interface for handling a collection of objects in a flexible and reusable manner.
---
- **List**: Extends `Collection` to represent an ordered collection, where elements can be accessed by their integer index.
    - Use case: Useful when a sequence of elements is required and allows duplicates.
---
- **Set**: Extends `Collection` to represent a collection with no duplicate elements.
    - Use case: Used when uniqueness is important, such as maintaining unique keys.
---
- **Queue**: Extends `Collection` to support operations for processing elements in FIFO (First In First Out) order.
    - Use case: Suitable for scenarios like task scheduling or buffering.
---
- **Deque**: A double-ended queue that allows elements to be inserted and removed from both ends.
    - Use case: Used when both stack and queue operations are needed.
---
- **Map**: Represents a key-value mapping with no duplicate keys.
    - Use case: Perfect for scenarios where data needs to be stored as key-value pairs, like a dictionary.
---
- **SortedSet**: Extends `Set` and ensures the elements are ordered in natural ordering or by a comparator.
    - Use case: For maintaining a sorted collection of unique elements.
---
- **NavigableSet**: Extends `SortedSet` to provide methods for navigating the set like `ceiling`, `floor`, etc.
    - Use case: Used in scenarios where advanced navigation through sorted sets is required.
---
- **SortedMap**: Extends `Map` and maintains key-value pairs in ascending key order.
    - Use case: Useful when sorted key-value pairs are needed, like for dictionaries that maintain sorted order.
---
- **NavigableMap**: Extends `SortedMap` and provides methods for navigation, such as `lowerKey`, `higherKey`.
    - Use case: Ideal for applications requiring advanced navigable map operations.

## Classes and Their Use Cases

- **ArrayList**: A resizable array implementation of the `List` interface.
    - Use case: Provides random access and dynamic array resizing.
---
- **LinkedList**: A doubly-linked list implementation of `List` and `Deque`.
    - Use case: Provides fast insertions and deletions at both ends of the list.
---
- **HashSet**: Implements the `Set` interface, backed by a hash table.
    - Use case: Provides constant-time performance for add, remove, and contains operations, while ensuring no duplicates.
---
- **TreeSet**: Implements the `SortedSet` interface, backed by a tree structure.
    - Use case: Used when sorted set functionality is needed.
---
- **HashMap**: Implements the `Map` interface, using a hash table.
    - Use case: Offers constant-time performance for retrieving values based on keys.
---
- **TreeMap**: Implements the `NavigableMap` interface, backed by a Red-Black tree.
    - Use case: Used for storing key-value pairs in a sorted order.
---
- **PriorityQueue**: Implements the `Queue` interface and processes elements in natural ordering or by comparator.
    - Use case: Useful for scenarios where priority processing of elements is required.
---
- **Vector**: A synchronized resizable array implementation of the `List` interface.
    - Use case: Provides thread-safe dynamic arrays for multithreaded environments.
---
## Code Examples

### Iterable Interface Example

```java
import java.util.ArrayList;

public class IterableExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        // Using for-each loop (works because ArrayList implements Iterable)
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```
### Collection Interface Example
```java
import java.util.ArrayList;
import java.util.Collection;

public class CollectionExample {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Iterating over the collection
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

### Vector Example
```java
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Iterating through Vector
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }
}
```