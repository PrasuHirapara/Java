# Java Collection Framework

## Overview

The **Java Collection Framework** provides a unified architecture for storing and manipulating a group of objects. It includes interfaces and classes for data structures like lists, sets, queues, and maps. The framework also provides algorithms for sorting, searching, and other manipulations.

### Advantages

1. **Standardization**: Provides a consistent API.
2. **Efficiency**: Optimized implementations for common data structures.
3. **Reusability**: Reduces development time with prebuilt classes.
4. **Flexibility**: Supports different data structures and use cases.
5. **Interoperability**: Easy integration with other libraries.

---

## Hierarchy of Java Collection Framework

![Hierarchy of Java Collection Framework](https://www.tutorialspoint.com/java/images/hierarchy-of-collection-framework.jpg)

The framework is divided into two main parts:

1. **Collection Interface** (for lists, sets, and queues)
2. **Map Interface** (for key-value pairs)

---

## Components of the Framework

### 1. **Iterable Interface**
- **Description**: Root interface for all collection types. Allows traversal of elements using an iterator.
- **Methods**:
    - `Iterator<T> iterator()`: Returns an iterator to traverse elements.
    - `void forEach(Consumer<? super T> action)`: Performs the given action for each element.
    - `Spliterator<T> spliterator()`: Creates a Spliterator over the elements.
    - `boolean hasNext()`: Checks if the iteration has more elements.
    - `T next()`: Retrieves the next element in the iteration.
    - `void remove()`: Removes the current element.
    - `void forEachRemaining(Consumer<? super T> action)`: Performs the given action for remaining elements.

#### Example:
```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
for (String item : list) {
    System.out.println(item);
}
```

---

### 2. **Collection Interface**
- **Description**: Root interface for List, Set, and Queue.
- **Methods**:
    - `boolean add(E e)`: Adds an element to the collection.
    - `boolean remove(Object o)`: Removes a specified element.
    - `int size()`: Returns the number of elements.
    - `void clear()`: Removes all elements.
    - `boolean contains(Object o)`: Checks if an element exists.
    - `Iterator<E> iterator()`: Returns an iterator for traversal.
    - `boolean isEmpty()`: Checks if the collection is empty.
    - `boolean addAll(Collection<? extends E> c)`: Adds all elements from the specified collection.
    - `boolean retainAll(Collection<?> c)`: Retains only elements present in the specified collection.
    - `boolean removeAll(Collection<?> c)`: Removes all elements from the specified collection.
    - `Object[] toArray()`: Converts the collection to an array.
    - `<T> T[] toArray(T[] a)`: Converts the collection to an array of specified type.
    - `default boolean removeIf(Predicate<? super E> filter)`: Removes elements satisfying the given predicate.
    - `default Spliterator<E> spliterator()`: Creates a Spliterator.

#### Example:
```java
Collection<Integer> collection = new ArrayList<>();
collection.add(10);
collection.add(20);
System.out.println("Size: " + collection.size());
```

---

### 3. **List Interface**
- **Description**: An ordered collection that allows duplicates.
- **Subtypes**: ArrayList, LinkedList, Vector, Stack.
- **Methods**:
    - `void add(int index, E element)`: Inserts an element at the specified position.
    - `E get(int index)`: Retrieves an element by index.
    - `E remove(int index)`: Removes an element by index.
    - `int indexOf(Object o)`: Returns the index of the first occurrence.
    - `int lastIndexOf(Object o)`: Returns the index of the last occurrence.
    - `List<E> subList(int fromIndex, int toIndex)`: Returns a portion of the list.
    - `void replaceAll(UnaryOperator<E> operator)`: Replaces each element with the result of applying the operator.
    - `void sort(Comparator<? super E> c)`: Sorts the list using the specified comparator.
    - `boolean containsAll(Collection<?> c)`: Checks if all elements are present.
    - `boolean equals(Object o)`: Checks equality with another list.
    - `int hashCode()`: Returns the hash code of the list.
    - `default void forEach(Consumer<? super E> action)`: Performs the given action for each element.

#### Example:
```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
System.out.println(list.get(0));
```

#### Subclasses of List:

# ArrayList Class
- **Description**: The `ArrayList` class in Java is a resizable array implementation of the `List` interface. It maintains the insertion order and allows duplicate elements. It is not synchronized but provides random access to elements.
- **Methods**:
    - `boolean add(E e)`: Appends the specified element to the end of the list.
    - `void add(int index, E element)`: Inserts the specified element at the specified position in the list.
    - `E get(int index)`: Returns the element at the specified position in the list.
    - `E set(int index, E element)`: Replaces the element at the specified position with the specified element.
    - `E remove(int index)`: Removes the element at the specified position in the list.
    - `boolean remove(Object o)`: Removes the first occurrence of the specified element.
    - `boolean contains(Object o)`: Returns `true` if the list contains the specified element.
    - `int indexOf(Object o)`: Returns the index of the first occurrence of the specified element.
    - `int lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element.
    - `boolean isEmpty()`: Returns `true` if the list contains no elements.
    - `int size()`: Returns the number of elements in the list.
    - `void clear()`: Removes all elements from the list.
    - `Object[] toArray()`: Returns an array containing all elements in the list.
    - `<T> T[] toArray(T[] a)`: Returns an array containing all elements in the list in the specified array type.
    - `void ensureCapacity(int minCapacity)`: Ensures that the list can hold at least the specified number of elements.
    - `void trimToSize()`: Trims the capacity of the list to its current size.

#### Example:
```java
package Collection;

import java.util.*;

public class ArrayListEx {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Display the list
        System.out.println("Initial List: " + list);

        // Add an element at a specific index
        list.add(1, "Blueberry");
        System.out.println("After adding Blueberry: " + list);

        // Get an element by index
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit);

        // Set an element at a specific index
        list.set(2, "Citrus");
        System.out.println("After setting Citrus at index 2: " + list);

        // Remove an element by index
        list.remove(1);
        System.out.println("After removing element at index 1: " + list);

        // Check if the list contains an element
        boolean hasApple = list.contains("Apple");
        System.out.println("Contains Apple: " + hasApple);

        // Get the size of the list
        int size = list.size();
        System.out.println("Size of the list: " + size);

        // Clear the list
        list.clear();
        System.out.println("List after clearing: " + list);
    }
}
```

# LinkedList Class
- **Description**: The `LinkedList` class in Java is a doubly-linked list implementation of the `List` and `Deque` interfaces. It allows insertion, deletion, and access of elements from both ends efficiently. It permits `null` elements and maintains the insertion order.
- **Methods**:
    - `boolean add(E e)`: Appends the specified element to the end of the list.
    - `void add(int index, E element)`: Inserts the specified element at the specified position in the list.
    - `void addFirst(E e)`: Inserts the specified element at the beginning of the list.
    - `void addLast(E e)`: Appends the specified element to the end of the list.
    - `E get(int index)`: Returns the element at the specified position in the list.
    - `E getFirst()`: Returns the first element in the list.
    - `E getLast()`: Returns the last element in the list.
    - `E set(int index, E element)`: Replaces the element at the specified position with the specified element.
    - `E remove(int index)`: Removes the element at the specified position in the list.
    - `E removeFirst()`: Removes and returns the first element in the list.
    - `E removeLast()`: Removes and returns the last element in the list.
    - `boolean remove(Object o)`: Removes the first occurrence of the specified element.
    - `boolean contains(Object o)`: Returns `true` if the list contains the specified element.
    - `int indexOf(Object o)`: Returns the index of the first occurrence of the specified element.
    - `int lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element.
    - `boolean isEmpty()`: Returns `true` if the list contains no elements.
    - `int size()`: Returns the number of elements in the list.
    - `void clear()`: Removes all elements from the list.
    - `Object[] toArray()`: Returns an array containing all elements in the list.
    - `<T> T[] toArray(T[] a)`: Returns an array containing all elements in the list in the specified array type.

#### Example:
```java
package Collection;

import java.util.*;

public class LinkedListEx {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Display the list
        System.out.println("Initial List: " + list);

        // Add an element at a specific index
        list.add(1, "Blueberry");
        System.out.println("After adding Blueberry: " + list);

        // Add an element at the beginning and end
        list.addFirst("Mango");
        list.addLast("Pineapple");
        System.out.println("After adding Mango and Pineapple: " + list);

        // Get an element by index
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit);

        // Get the first and last elements
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        // Remove an element by index
        list.remove(1);
        System.out.println("After removing element at index 1: " + list);

        // Remove the first and last elements
        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first and last elements: " + list);

        // Check if the list contains an element
        boolean hasApple = list.contains("Apple");
        System.out.println("Contains Apple: " + hasApple);

        // Get the size of the list
        int size = list.size();
        System.out.println("Size of the list: " + size);

        // Clear the list
        list.clear();
        System.out.println("List after clearing: " + list);
    }
}
```

# Vector Class
- **Description**: The `Vector` class in Java implements a growable array of objects. It is synchronized, making it thread-safe. The capacity of a `Vector` is dynamically increased as elements are added.
- **Methods**:
    - `boolean add(E e)`: Appends the specified element to the end of the vector.
    - `void add(int index, E element)`: Inserts the specified element at the specified position in the vector.
    - `boolean addAll(Collection<? extends E> c)`: Appends all elements from the specified collection to the end of the vector.
    - `boolean addAll(int index, Collection<? extends E> c)`: Inserts all elements from the specified collection at the specified position in the vector.
    - `E get(int index)`: Returns the element at the specified position in the vector.
    - `E set(int index, E element)`: Replaces the element at the specified position with the specified element.
    - `E remove(int index)`: Removes the element at the specified position in the vector.
    - `boolean remove(Object o)`: Removes the first occurrence of the specified element from the vector.
    - `boolean contains(Object o)`: Returns `true` if the vector contains the specified element.
    - `int indexOf(Object o)`: Returns the index of the first occurrence of the specified element.
    - `int lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element.
    - `boolean isEmpty()`: Returns `true` if the vector contains no elements.
    - `int size()`: Returns the number of elements in the vector.
    - `void clear()`: Removes all elements from the vector.
    - `Object[] toArray()`: Returns an array containing all elements in the vector.
    - `<T> T[] toArray(T[] a)`: Returns an array containing all elements in the vector in the specified array type.
    - `void ensureCapacity(int minCapacity)`: Ensures that the vector can hold at least the specified number of elements.
    - `void trimToSize()`: Trims the capacity of the vector to its current size.
    - `Enumeration<E> elements()`: Returns an enumeration of the elements in the vector.
    - `E firstElement()`: Returns the first element in the vector.
    - `E lastElement()`: Returns the last element in the vector.
    - `void removeAllElements()`: Removes all elements from the vector.

#### Example:
```java
package Collection;

import java.util.*;

public class VectorEx {
    public static void main(String[] args) {
        // Create a Vector of Strings
        Vector<String> vector = new Vector<>();

        // Add elements to the vector
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Display the vector
        System.out.println("Initial Vector: " + vector);

        // Add an element at a specific index
        vector.add(1, "Blueberry");
        System.out.println("After adding Blueberry: " + vector);

        // Get an element by index
        String fruit = vector.get(2);
        System.out.println("Element at index 2: " + fruit);

        // Set an element at a specific index
        vector.set(2, "Citrus");
        System.out.println("After setting Citrus at index 2: " + vector);

        // Remove an element by index
        vector.remove(1);
        System.out.println("After removing element at index 1: " + vector);

        // Check if the vector contains an element
        boolean hasApple = vector.contains("Apple");
        System.out.println("Contains Apple: " + hasApple);

        // Get the first and last elements
        System.out.println("First Element: " + vector.firstElement());
        System.out.println("Last Element: " + vector.lastElement());

        // Get the size of the vector
        int size = vector.size();
        System.out.println("Size of the vector: " + size);

        // Clear the vector
        vector.clear();
        System.out.println("Vector after clearing: " + vector);
    }
}
```

# Stack Class
- **Description**: The `Stack` class in Java represents a last-in-first-out (LIFO) stack of objects. It extends `Vector` and includes methods that provide stack operations as well as inherited methods from `Vector`.
- **Methods**:
    - **Stack-Specific Methods:**
        - `E push(E item)`: Pushes an item onto the top of the stack.
        - `E pop()`: Removes and returns the item at the top of the stack. Throws an exception if the stack is empty.
        - `E peek()`: Returns the item at the top of the stack without removing it. Throws an exception if the stack is empty.
        - `boolean empty()`: Checks if the stack is empty.
        - `int search(Object o)`: Returns the 1-based position of an object in the stack. Returns `-1` if the object is not found.

    - **Inherited Methods from Vector:**
        - `boolean add(E e)`: Appends the specified element to the end of the list.
        - `void add(int index, E element)`: Inserts the specified element at the specified position in the list.
        - `boolean addAll(Collection<? extends E> c)`: Appends all elements in the specified collection to the end of the list.
        - `boolean addAll(int index, Collection<? extends E> c)`: Inserts all elements from the specified collection at the specified position in the list.
        - `void clear()`: Removes all elements from the list.
        - `boolean contains(Object o)`: Returns `true` if the list contains the specified element.
        - `boolean containsAll(Collection<?> c)`: Returns `true` if the list contains all elements in the specified collection.
        - `E elementAt(int index)`: Returns the element at the specified position.
        - `Enumeration<E> elements()`: Returns an enumeration of the elements in the list.
        - `void ensureCapacity(int minCapacity)`: Ensures that the capacity is at least the specified minimum.
        - `E firstElement()`: Returns the first element in the list.
        - `E get(int index)`: Returns the element at the specified position.
        - `int indexOf(Object o)`: Returns the index of the first occurrence of the specified element.
        - `int indexOf(Object o, int index)`: Returns the index of the first occurrence of the specified element starting at the specified position.
        - `void insertElementAt(E obj, int index)`: Inserts the specified element at the specified position.
        - `boolean isEmpty()`: Checks if the list is empty.
        - `E lastElement()`: Returns the last element in the list.
        - `int lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element.
        - `int lastIndexOf(Object o, int index)`: Returns the index of the last occurrence of the specified element starting at the specified position.
        - `E remove(int index)`: Removes the element at the specified position.
        - `boolean remove(Object o)`: Removes the first occurrence of the specified element.
        - `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection.
        - `void removeAllElements()`: Removes all elements from the vector.
        - `boolean removeElement(Object obj)`: Removes the first occurrence of the specified element.
        - `void removeElementAt(int index)`: Removes the element at the specified position.
        - `boolean retainAll(Collection<?> c)`: Retains only the elements in the specified collection.
        - `E set(int index, E element)`: Replaces the element at the specified position.
        - `void setElementAt(E obj, int index)`: Sets the specified object at the specified position.
        - `int size()`: Returns the number of elements in the list.
        - `List<E> subList(int fromIndex, int toIndex)`: Returns a view of the portion of the list between the specified indices.
        - `Object[] toArray()`: Returns an array containing all elements in the list.
        - `<T> T[] toArray(T[] a)`: Returns an array containing all elements in the list of the specified type.
        - `void trimToSize()`: Trims the capacity of the vector to its current size.

#### Example:
```java
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
```

---

### 4. **Set Interface**

- **Description**: Represents an unordered collection of unique elements.
- **Subtypes**: HashSet, LinkedHashSet, TreeSet.
- **Methods**:
    - `boolean add(E e)`: Adds an element to the set.
    - `boolean remove(Object o)`: Removes a specified element.
    - `int size()`: Returns the number of elements in the set.
    - `void clear()`: Removes all elements.
    - `boolean contains(Object o)`: Checks if an element exists.
    - `Iterator<E> iterator()`: Returns an iterator for traversal.
    - `boolean isEmpty()`: Checks if the set is empty.
    - `boolean addAll(Collection<? extends E> c)`: Adds all elements from the specified collection.
    - `boolean retainAll(Collection<?> c)`: Retains only elements present in the specified collection.
    - `boolean removeAll(Collection<?> c)`: Removes all elements from the specified collection.
    - `Object[] toArray()`: Converts the set to an array.
    - `<T> T[] toArray(T[] a)`: Converts the set to an array of specified type.
    - `default boolean removeIf(Predicate<? super E> filter)`: Removes elements satisfying the given predicate.
    - `default Spliterator<E> spliterator()`: Creates a Spliterator.

#### Example:
```java
Set<String> set = new HashSet<>();
set.add("Java");
set.add("Python");
System.out.println(set.contains("Java"));
```

#### Subclasses of Set:

# HashSet Class

- **Description**: The `HashSet` class in Java is a collection that implements the `Set` interface, backed by a hash table. It does not allow duplicate elements and provides constant-time performance for basic operations such as add, remove, and contains. It is part of the `java.util` package and permits `null` elements.

- **Methods**:
    - **HashSet Methods:**
        - `boolean add(E e)`: Adds the specified element to the set if it is not already present.
        - `boolean remove(Object o)`: Removes the specified element from the set if it is present.
        - `boolean contains(Object o)`: Returns `true` if the set contains the specified element.
        - `void clear()`: Removes all elements from the set.
        - `boolean isEmpty()`: Checks if the set is empty.
        - `int size()`: Returns the number of elements in the set.
        - `boolean addAll(Collection<? extends E> c)`: Adds all elements in the specified collection to the set.
        - `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection from the set.
        - `boolean retainAll(Collection<?> c)`: Retains only the elements in the specified collection.
        - `Object[] toArray()`: Returns an array containing all elements in the set.
        - `<T> T[] toArray(T[] a)`: Returns an array containing all elements in the set of the specified type.

#### Example:
```java
package Collection;

import java.util.*;

public class HashSetEx {
    public static void main(String[] args) {
        // Create a HashSet of Strings
        HashSet<String> set = new HashSet<>();

        // Add elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // Display the HashSet
        System.out.println("HashSet: " + set);

        // Check if an element is present
        boolean containsApple = set.contains("Apple");
        System.out.println("Contains 'Apple': " + containsApple);

        // Remove an element from the HashSet
        set.remove("Banana");
        System.out.println("After removing 'Banana': " + set);

        // Get the size of the HashSet
        int size = set.size();
        System.out.println("Size of HashSet: " + size);

        // Add all elements from another collection
        List<String> additionalElements = Arrays.asList("Date", "Elderberry");
        set.addAll(additionalElements);
        System.out.println("After adding all elements from list: " + set);

        // Retain only specific elements
        set.retainAll(Collections.singleton("Apple"));
        System.out.println("After retaining only 'Apple': " + set);

        // Convert the HashSet to an array
        String[] array = set.toArray(new String[0]);
        System.out.println("HashSet as array: " + Arrays.toString(array));

        // Check if the HashSet is empty
        boolean isEmpty = set.isEmpty();
        System.out.println("Is HashSet Empty: " + isEmpty);

        // Clear the HashSet
        set.clear();
        System.out.println("HashSet after clearing: " + set);
    }
}
```

# LinkedHashSet Class

- **Description**: The `LinkedHashSet` class in Java is a collection that implements the `Set` interface and extends `HashSet`. It maintains a linked list of the entries in the set to preserve the order in which elements were inserted. Like `HashSet`, it does not allow duplicate elements and permits `null` elements. It is part of the `java.util` package.

- **Methods**:
    - **LinkedHashSet Methods:**
        - `boolean add(E e)`: Adds the specified element to the set if it is not already present.
        - `boolean remove(Object o)`: Removes the specified element from the set if it is present.
        - `boolean contains(Object o)`: Returns `true` if the set contains the specified element.
        - `void clear()`: Removes all elements from the set.
        - `boolean isEmpty()`: Checks if the set is empty.
        - `int size()`: Returns the number of elements in the set.
        - `boolean addAll(Collection<? extends E> c)`: Adds all elements in the specified collection to the set.
        - `boolean removeAll(Collection<?> c)`: Removes all elements in the specified collection from the set.
        - `boolean retainAll(Collection<?> c)`: Retains only the elements in the specified collection.
        - `Object[] toArray()`: Returns an array containing all elements in the set.
        - `<T> T[] toArray(T[] a)`: Returns an array containing all elements in the set of the specified type.

#### Example:
```java
package Collection;

import java.util.*;

public class LinkedHashSetEx {
    public static void main(String[] args) {
        // Create a LinkedHashSet of Strings
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // Add elements to the LinkedHashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // Display the LinkedHashSet
        System.out.println("LinkedHashSet: " + set);

        // Check if an element is present
        boolean containsApple = set.contains("Apple");
        System.out.println("Contains 'Apple': " + containsApple);

        // Remove an element from the LinkedHashSet
        set.remove("Banana");
        System.out.println("After removing 'Banana': " + set);

        // Get the size of the LinkedHashSet
        int size = set.size();
        System.out.println("Size of LinkedHashSet: " + size);

        // Add all elements from another collection
        List<String> additionalElements = Arrays.asList("Date", "Elderberry");
        set.addAll(additionalElements);
        System.out.println("After adding all elements from list: " + set);

        // Retain only specific elements
        set.retainAll(Collections.singleton("Apple"));
        System.out.println("After retaining only 'Apple': " + set);

        // Convert the LinkedHashSet to an array
        String[] array = set.toArray(new String[0]);
        System.out.println("LinkedHashSet as array: " + Arrays.toString(array));

        // Clear the LinkedHashSet
        set.clear();
        System.out.println("LinkedHashSet after clearing: " + set);

        // Check if the LinkedHashSet is empty
        boolean isEmpty = set.isEmpty();
        System.out.println("Is LinkedHashSet Empty: " + isEmpty);
    }
}
```

# TreeSet Class

- **Description**: The `TreeSet` class in Java is a collection that implements the `NavigableSet` interface and extends `AbstractSet`. It uses a `TreeMap` internally to store elements in a sorted and ascending order. The `TreeSet` does not allow duplicate elements and does not permit `null` values. It is part of the `java.util` package.

- **Methods**:
    - **TreeSet Methods:**
        - `boolean add(E e)`: Adds the specified element to the set if it is not already present.
        - `boolean remove(Object o)`: Removes the specified element from the set if it is present.
        - `boolean contains(Object o)`: Returns `true` if the set contains the specified element.
        - `void clear()`: Removes all elements from the set.
        - `boolean isEmpty()`: Checks if the set is empty.
        - `int size()`: Returns the number of elements in the set.
        - `E first()`: Returns the first (lowest) element currently in the set.
        - `E last()`: Returns the last (highest) element currently in the set.
        - `E lower(E e)`: Returns the greatest element in the set strictly less than the given element, or `null` if no such element exists.
        - `E higher(E e)`: Returns the least element in the set strictly greater than the given element, or `null` if no such element exists.
        - `E floor(E e)`: Returns the greatest element in the set less than or equal to the given element, or `null` if no such element exists.
        - `E ceiling(E e)`: Returns the least element in the set greater than or equal to the given element, or `null` if no such element exists.
        - `Iterator<E> iterator()`: Returns an iterator over the elements in ascending order.
        - `Iterator<E> descendingIterator()`: Returns an iterator over the elements in descending order.
        - `SortedSet<E> headSet(E toElement)`: Returns a view of the portion of this set whose elements are strictly less than `toElement`.
        - `SortedSet<E> tailSet(E fromElement)`: Returns a view of the portion of this set whose elements are greater than or equal to `fromElement`.
        - `SortedSet<E> subSet(E fromElement, E toElement)`: Returns a view of the portion of this set whose elements range from `fromElement`, inclusive, to `toElement`, exclusive.

#### Example:
```java
package Collection;

import java.util.*;

public class TreeSetEx {
    public static void main(String[] args) {
        // Create a TreeSet of Integers
        TreeSet<Integer> set = new TreeSet<>();

        // Add elements to the TreeSet
        set.add(10);
        set.add(20);
        set.add(30);

        // Display the TreeSet
        System.out.println("TreeSet: " + set);

        // Check if an element is present
        boolean contains20 = set.contains(20);
        System.out.println("Contains 20: " + contains20);

        // Remove an element from the TreeSet
        set.remove(10);
        System.out.println("After removing 10: " + set);

        // Get the size of the TreeSet
        int size = set.size();
        System.out.println("Size of TreeSet: " + size);

        // Retrieve the first and last elements
        int first = set.first();
        int last = set.last();
        System.out.println("First Element: " + first);
        System.out.println("Last Element: " + last);

        // Find lower, higher, floor, and ceiling elements
        System.out.println("Lower than 30: " + set.lower(30));
        System.out.println("Higher than 20: " + set.higher(20));
        System.out.println("Floor of 25: " + set.floor(25));
        System.out.println("Ceiling of 15: " + set.ceiling(15));

        // Use subset, headset, and tailset methods
        System.out.println("Subset (20 to 40): " + set.subSet(20, 40));
        System.out.println("HeadSet (up to 30): " + set.headSet(30));
        System.out.println("TailSet (from 20): " + set.tailSet(20));

        // Clear the TreeSet
        set.clear();
        System.out.println("TreeSet after clearing: " + set);

        // Check if the TreeSet is empty
        boolean isEmpty = set.isEmpty();
        System.out.println("Is TreeSet Empty: " + isEmpty);
    }
}
```

---

### 5. **Map Interface**

- **Description**: Represents a collection of key-value pairs, where each key is unique.
- **Subtypes**: HashMap, LinkedHashMap, TreeMap, Hashtable.
- **Methods**:
    - `V put(K key, V value)`: Associates the specified value with the specified key.
    - `V get(Object key)`: Returns the value to which the specified key is mapped.
    - `boolean containsKey(Object key)`: Checks if the map contains the specified key.
    - `boolean containsValue(Object value)`: Checks if the map contains the specified value.
    - `V remove(Object key)`: Removes the mapping for a key.
    - `int size()`: Returns the number of key-value mappings.
    - `boolean isEmpty()`: Checks if the map is empty.
    - `void clear()`: Removes all mappings.
    - `Set<K> keySet()`: Returns a set of all keys.
    - `Collection<V> values()`: Returns a collection of all values.
    - `Set<Map.Entry<K, V>> entrySet()`: Returns a set of all key-value mappings.
    - `V putIfAbsent(K key, V value)`: Associates the value with the key if absent.
    - `boolean remove(Object key, Object value)`: Removes the key-value pair if it matches.
    - `boolean replace(K key, V oldValue, V newValue)`: Replaces the entry if the current value matches the old value.
    - `V replace(K key, V value)`: Replaces the value for the specified key.
    - `void forEach(BiConsumer<? super K, ? super V> action)`: Performs the given action for each entry.
    - `void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)`: Replaces all values using the given function.

#### Example:
```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "Java");
map.put(2, "Python");
System.out.println(map.get(1)); // Output: Java
```

#### Subclasses of Map:

# HashMap Class

- **Description**: The `HashMap` class in Java is part of the `java.util` package and provides a hash table-based implementation of the `Map` interface. It allows the storage of key-value pairs, where keys are unique, and values can be duplicate. The `HashMap` permits one `null` key and multiple `null` values but is not synchronized.

- **Methods**:
    - **HashMap Methods:**
        - `V put(K key, V value)`: Associates the specified value with the specified key in the map.
        - `V get(Object key)`: Returns the value to which the specified key is mapped, or `null` if the map contains no mapping for the key.
        - `V remove(Object key)`: Removes the mapping for a key from this map if it is present.
        - `boolean containsKey(Object key)`: Returns `true` if the map contains a mapping for the specified key.
        - `boolean containsValue(Object value)`: Returns `true` if the map maps one or more keys to the specified value.
        - `void clear()`: Removes all the mappings from this map.
        - `boolean isEmpty()`: Checks if the map is empty.
        - `int size()`: Returns the number of key-value mappings in the map.
        - `Set<K> keySet()`: Returns a `Set` view of the keys contained in this map.
        - `Collection<V> values()`: Returns a `Collection` view of the values contained in this map.
        - `Set<Map.Entry<K, V>> entrySet()`: Returns a `Set` view of the mappings contained in this map.
        - `V putIfAbsent(K key, V value)`: Associates the specified key with the specified value if it is not already associated with a value.
        - `boolean replace(K key, V oldValue, V newValue)`: Replaces the entry for the specified key only if it is currently mapped to the specified value.
        - `V replace(K key, V value)`: Replaces the entry for the specified key with the specified value.
        - `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`: Computes a value for the specified key if it is not already present and associates it with the key.
        - `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new mapping for the specified key if it is already associated with a value.
        - `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Attempts to compute a mapping for the specified key and its current mapped value.
        - `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`: Merges the specified value with the existing value for the specified key using the given remapping function.

#### Example:
```java
package Collection;

import java.util.*;

public class HashMapEx {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Add key-value pairs to the HashMap
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Display the HashMap
        System.out.println("HashMap: " + map);

        // Retrieve a value
        String value = map.get(2);
        System.out.println("Value for key 2: " + value);

        // Check if a key is present
        boolean containsKey = map.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Check if a value is present
        boolean containsValue = map.containsValue("Apple");
        System.out.println("Contains value 'Apple': " + containsValue);

        // Remove a key-value pair
        map.remove(1);
        System.out.println("After removing key 1: " + map);

        // Use putIfAbsent
        map.putIfAbsent(4, "Date");
        System.out.println("After putIfAbsent: " + map);

        // Use computeIfAbsent
        map.computeIfAbsent(5, key -> "Elderberry");
        System.out.println("After computeIfAbsent: " + map);

        // Use computeIfPresent
        map.computeIfPresent(2, (key, val) -> val + " Updated");
        System.out.println("After computeIfPresent: " + map);

        // Use compute
        map.compute(3, (key, val) -> val == null ? "Fig" : val + " Updated");
        System.out.println("After compute: " + map);

        // Use merge
        map.merge(3, "Grape", (oldVal, newVal) -> oldVal + ", " + newVal);
        System.out.println("After merge: " + map);

        // Get the size of the HashMap
        int size = map.size();
        System.out.println("Size of HashMap: " + size);

        // Iterate over the keys
        System.out.println("Keys: " + map.keySet());

        // Iterate over the values
        System.out.println("Values: " + map.values());

        // Iterate over the key-value pairs
        System.out.println("Entries: " + map.entrySet());

        // Clear the HashMap
        map.clear();
        System.out.println("HashMap after clearing: " + map);

        // Check if the HashMap is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is HashMap Empty: " + isEmpty);
    }
}
```

# LinkedHashMap Class

- **Description**: The `LinkedHashMap` class in Java is a hash table and linked list implementation of the `Map` interface. It maintains a doubly-linked list running through its entries, preserving the order of insertion or access order (if access-order mode is enabled). This makes it predictable in iteration order compared to `HashMap`.

- **Methods**:
    - **LinkedHashMap-Specific Methods:**
        - `boolean removeEldestEntry(Map.Entry<K, V> eldest)`: Determines if the eldest entry should be removed from the map as part of a policy. This method is called by `put` and `putAll` after inserting a new entry.

    - **Inherited Methods from HashMap:**
        - `V put(K key, V value)`: Associates the specified value with the specified key in the map.
        - `V get(Object key)`: Returns the value to which the specified key is mapped, or `null` if the map contains no mapping for the key.
        - `V remove(Object key)`: Removes the mapping for a key from this map if it is present.
        - `boolean containsKey(Object key)`: Returns `true` if the map contains a mapping for the specified key.
        - `boolean containsValue(Object value)`: Returns `true` if the map maps one or more keys to the specified value.
        - `void clear()`: Removes all the mappings from this map.
        - `boolean isEmpty()`: Checks if the map is empty.
        - `int size()`: Returns the number of key-value mappings in the map.
        - `Set<K> keySet()`: Returns a `Set` view of the keys contained in this map.
        - `Collection<V> values()`: Returns a `Collection` view of the values contained in this map.
        - `Set<Map.Entry<K, V>> entrySet()`: Returns a `Set` view of the mappings contained in this map.
        - `V putIfAbsent(K key, V value)`: Associates the specified key with the specified value if it is not already associated with a value.
        - `boolean replace(K key, V oldValue, V newValue)`: Replaces the entry for the specified key only if it is currently mapped to the specified value.
        - `V replace(K key, V value)`: Replaces the entry for the specified key with the specified value.
        - `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`: Computes a value for the specified key if it is not already present and associates it with the key.
        - `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Computes a new mapping for the specified key if it is already associated with a value.
        - `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`: Attempts to compute a mapping for the specified key and its current mapped value.
        - `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`: Merges the specified value with the existing value for the specified key using the given remapping function.

#### Example:
```java
package Collection;

import java.util.*;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        // Create a LinkedHashMap
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();

        // Add key-value pairs to the LinkedHashMap
        linkedMap.put(1, "Apple");
        linkedMap.put(2, "Banana");
        linkedMap.put(3, "Cherry");

        // Display the LinkedHashMap
        System.out.println("LinkedHashMap: " + linkedMap);

        // Retrieve a value
        String value = linkedMap.get(2);
        System.out.println("Value for key 2: " + value);

        // Check if a key is present
        boolean containsKey = linkedMap.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Check if a value is present
        boolean containsValue = linkedMap.containsValue("Apple");
        System.out.println("Contains value 'Apple': " + containsValue);

        // Remove a key-value pair
        linkedMap.remove(1);
        System.out.println("After removing key 1: " + linkedMap);

        // Use putIfAbsent
        linkedMap.putIfAbsent(4, "Date");
        System.out.println("After putIfAbsent: " + linkedMap);

        // Use computeIfAbsent
        linkedMap.computeIfAbsent(5, key -> "Elderberry");
        System.out.println("After computeIfAbsent: " + linkedMap);

        // Use computeIfPresent
        linkedMap.computeIfPresent(2, (key, val) -> val + " Updated");
        System.out.println("After computeIfPresent: " + linkedMap);

        // Use compute
        linkedMap.compute(3, (key, val) -> val == null ? "Fig" : val + " Updated");
        System.out.println("After compute: " + linkedMap);

        // Use merge
        linkedMap.merge(3, "Grape", (oldVal, newVal) -> oldVal + ", " + newVal);
        System.out.println("After merge: " + linkedMap);

        // Iterate over the keys
        System.out.println("Keys: " + linkedMap.keySet());

        // Iterate over the values
        System.out.println("Values: " + linkedMap.values());

        // Iterate over the key-value pairs
        System.out.println("Entries: " + linkedMap.entrySet());

        // Check if the LinkedHashMap is empty
        boolean isEmpty = linkedMap.isEmpty();
        System.out.println("Is LinkedHashMap Empty: " + isEmpty);
    }
}
```

# TreeMap Class

- **Description**: The `TreeMap` class in Java is part of the `java.util` package and provides a `Map` implementation that is sorted in natural order or by a custom comparator. It is based on a Red-Black tree and guarantees that the keys will always be in ascending order.

- **Methods**:
    - **TreeMap Methods:**
        - `V put(K key, V value)`: Associates the specified value with the specified key in this map.
        - `V get(Object key)`: Returns the value to which the specified key is mapped, or `null` if the map contains no mapping for the key.
        - `V remove(Object key)`: Removes the mapping for a key from this map if it is present.
        - `boolean containsKey(Object key)`: Returns `true` if this map contains a mapping for the specified key.
        - `boolean containsValue(Object value)`: Returns `true` if this map maps one or more keys to the specified value.
        - `void clear()`: Removes all the mappings from this map.
        - `boolean isEmpty()`: Checks if the map is empty.
        - `int size()`: Returns the number of key-value mappings in this map.
        - `Set<K> keySet()`: Returns a `Set` view of the keys contained in this map.
        - `Collection<V> values()`: Returns a `Collection` view of the values contained in this map.
        - `Set<Map.Entry<K, V>> entrySet()`: Returns a `Set` view of the mappings contained in this map.
        - `K firstKey()`: Returns the first (lowest) key currently in this map.
        - `K lastKey()`: Returns the last (highest) key currently in this map.
        - `K ceilingKey(K key)`: Returns the least key greater than or equal to the given key, or `null` if there is no such key.
        - `K floorKey(K key)`: Returns the greatest key less than or equal to the given key, or `null` if there is no such key.
        - `K higherKey(K key)`: Returns the least key strictly greater than the given key, or `null` if there is no such key.
        - `K lowerKey(K key)`: Returns the greatest key strictly less than the given key, or `null` if there is no such key.
        - `Map.Entry<K, V> firstEntry()`: Returns a key-value mapping associated with the lowest key, or `null` if the map is empty.
        - `Map.Entry<K, V> lastEntry()`: Returns a key-value mapping associated with the highest key, or `null` if the map is empty.
        - `Map.Entry<K, V> ceilingEntry(K key)`: Returns a key-value mapping associated with the least key greater than or equal to the given key, or `null` if there is no such key.
        - `Map.Entry<K, V> floorEntry(K key)`: Returns a key-value mapping associated with the greatest key less than or equal to the given key, or `null` if there is no such key.
        - `Map.Entry<K, V> higherEntry(K key)`: Returns a key-value mapping associated with the least key strictly greater than the given key, or `null` if there is no such key.
        - `Map.Entry<K, V> lowerEntry(K key)`: Returns a key-value mapping associated with the greatest key strictly less than the given key, or `null` if there is no such key.
        - `NavigableSet<K> navigableKeySet()`: Returns a `NavigableSet` view of the keys contained in this map.

#### Example:
```java
package Collection;

import java.util.*;

public class TreeMapEx {
    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<Integer, String> map = new TreeMap<>();

        // Add key-value pairs to the TreeMap
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Display the TreeMap
        System.out.println("TreeMap: " + map);

        // Retrieve a value
        String value = map.get(2);
        System.out.println("Value for key 2: " + value);

        // Check if a key is present
        boolean containsKey = map.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Check if a value is present
        boolean containsValue = map.containsValue("Apple");
        System.out.println("Contains value 'Apple': " + containsValue);

        // Remove a key-value pair
        map.remove(1);
        System.out.println("After removing key 1: " + map);

        // Get first and last keys
        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());

        // Use ceilingKey, floorKey, higherKey, and lowerKey
        System.out.println("Ceiling Key (2): " + map.ceilingKey(2));
        System.out.println("Floor Key (2): " + map.floorKey(2));
        System.out.println("Higher Key (2): " + map.higherKey(2));
        System.out.println("Lower Key (2): " + map.lowerKey(2));

        // Iterate over the keys
        System.out.println("Keys: " + map.keySet());

        // Iterate over the values
        System.out.println("Values: " + map.values());

        // Iterate over the key-value pairs
        System.out.println("Entries: " + map.entrySet());

        // Clear the TreeMap
        map.clear();
        System.out.println("TreeMap after clearing: " + map);

        // Check if the TreeMap is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is TreeMap Empty: " + isEmpty);
    }
}
```
# Hashtable Class

- **Description**: The `Hashtable` class in Java is a part of the `java.util` package and implements a hash table that maps keys to values. It is synchronized, meaning it is thread-safe but less efficient compared to `HashMap`. Neither the key nor the value can be `null` in a `Hashtable`.

- **Methods**:
    - **Hashtable Methods:**
        - `V put(K key, V value)`: Associates the specified value with the specified key in this hashtable.
        - `V get(Object key)`: Returns the value to which the specified key is mapped, or `null` if this hashtable contains no mapping for the key.
        - `V remove(Object key)`: Removes the key (and its corresponding value) from this hashtable.
        - `boolean containsKey(Object key)`: Tests if the specified object is a key in this hashtable.
        - `boolean containsValue(Object value)`: Returns `true` if this hashtable maps one or more keys to the specified value.
        - `boolean isEmpty()`: Checks if the hashtable is empty.
        - `int size()`: Returns the number of key-value mappings in the hashtable.
        - `Enumeration<K> keys()`: Returns an enumeration of the keys in this hashtable.
        - `Enumeration<V> elements()`: Returns an enumeration of the values in this hashtable.
        - `void clear()`: Clears this hashtable so that it contains no keys.
        - `boolean equals(Object o)`: Compares the specified object with this map for equality.
        - `int hashCode()`: Returns the hash code value for this map.
        - `V putIfAbsent(K key, V value)`: If the specified key is not already associated with a value, associates it with the given value.
        - `boolean replace(K key, V oldValue, V newValue)`: Replaces the entry for the specified key only if currently mapped to the specified value.
        - `V replace(K key, V value)`: Replaces the entry for the specified key with the specified value.

#### Example:
```java
package Collection;

import java.util.*;

public class HashtableEx {
    public static void main(String[] args) {
        // Create a Hashtable
        Hashtable<Integer, String> table = new Hashtable<>();

        // Add key-value pairs
        table.put(1, "Apple");
        table.put(2, "Banana");
        table.put(3, "Cherry");

        // Display the Hashtable
        System.out.println("Hashtable: " + table);

        // Retrieve a value
        String value = table.get(2);
        System.out.println("Value for key 2: " + value);

        // Check if a key is present
        boolean containsKey = table.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Check if a value is present
        boolean containsValue = table.containsValue("Apple");
        System.out.println("Contains value 'Apple': " + containsValue);

        // Remove a key-value pair
        table.remove(1);
        System.out.println("After removing key 1: " + table);

        // Use putIfAbsent
        table.putIfAbsent(4, "Date");
        System.out.println("After putIfAbsent: " + table);

        // Use replace
        table.replace(2, "Banana", "Blueberry");
        System.out.println("After replace: " + table);

        // Iterate over keys
        System.out.println("Keys: " + table.keySet());

        // Iterate over values
        System.out.println("Values: " + table.values());

        // Iterate over entries
        System.out.println("Entries: " + table.entrySet());

        // Get the size of the Hashtable
        int size = table.size();
        System.out.println("Size of Hashtable: " + size);

        // Clear the Hashtable
        table.clear();
        System.out.println("Hashtable after clearing: " + table);

        // Check if the Hashtable is empty
        boolean isEmpty = table.isEmpty();
        System.out.println("Is Hashtable Empty: " + isEmpty);
    }
}
```

---

### 6. **Queue Interface**

- **Description**: Represents a collection designed for holding elements prior to processing. Follows the First-In-First-Out (FIFO) principle.
- **Subtypes**: LinkedList, PriorityQueue, ArrayDeque.
- **Methods**:
    - `boolean add(E e)`: Inserts the specified element into the queue. Throws an exception if the operation fails.
    - `boolean offer(E e)`: Inserts the specified element into the queue. Returns `false` if the operation fails.
    - `E remove()`: Retrieves and removes the head of the queue. Throws an exception if the queue is empty.
    - `E poll()`: Retrieves and removes the head of the queue. Returns `null` if the queue is empty.
    - `E element()`: Retrieves the head of the queue without removing it. Throws an exception if the queue is empty.
    - `E peek()`: Retrieves the head of the queue without removing it. Returns `null` if the queue is empty.

#### Example:
```java
Queue<Integer> queue = new LinkedList<>();
queue.add(1);
queue.add(2);
queue.add(3);
System.out.println(queue.poll()); // Output: 1
System.out.println(queue.peek()); // Output: 2
```

#### Subclasses of Queue:

# PriorityQueue Class

- **Description**: The `PriorityQueue` class in Java is part of the `java.util` package and implements a priority heap-based queue. It orders elements either according to their natural order or based on a `Comparator` provided at the queue's construction time. `PriorityQueue` does not permit `null` elements and is not thread-safe.

- **Methods**:
    - **PriorityQueue-Specific Methods:**
        - `boolean add(E e)`: Inserts the specified element into this priority queue.
        - `boolean offer(E e)`: Inserts the specified element into this priority queue.
        - `E peek()`: Retrieves, but does not remove, the head of this queue, or returns `null` if this queue is empty.
        - `E poll()`: Retrieves and removes the head of this queue, or returns `null` if this queue is empty.
        - `boolean remove(Object o)`: Removes a single instance of the specified element from this queue, if it is present.
        - `boolean contains(Object o)`: Returns `true` if this queue contains the specified element.
        - `int size()`: Returns the number of elements in this queue.
        - `void clear()`: Removes all elements from the queue.
        - `Object[] toArray()`: Returns an array containing all elements in this queue.
        - `<T> T[] toArray(T[] a)`: Returns an array containing all elements in this queue, using the specified array.

#### Example:
```java
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
```

### 7. **Deque Interface**

- **Description**: Represents a double-ended queue that supports element insertion and removal at both ends.
- **Subtypes**: `LinkedList`, `ArrayDeque`.
- **Methods**:
    - `void addFirst(E e)`: Inserts the specified element at the front.
    - `void addLast(E e)`: Inserts the specified element at the end.
    - `boolean offerFirst(E e)`: Inserts the specified element at the front. Returns `false` if the operation fails.
    - `boolean offerLast(E e)`: Inserts the specified element at the end. Returns `false` if the operation fails.
    - `E removeFirst()`: Removes and retrieves the first element. Throws an exception if the deque is empty.
    - `E removeLast()`: Removes and retrieves the last element. Throws an exception if the deque is empty.
    - `E pollFirst()`: Removes and retrieves the first element. Returns `null` if the deque is empty.
    - `E pollLast()`: Removes and retrieves the last element. Returns `null` if the deque is empty.
    - `E getFirst()`: Retrieves the first element without removing it. Throws an exception if the deque is empty.
    - `E getLast()`: Retrieves the last element without removing it. Throws an exception if the deque is empty.
    - `E peekFirst()`: Retrieves the first element without removing it. Returns `null` if the deque is empty.
    - `E peekLast()`: Retrieves the last element without removing it. Returns `null` if the deque is empty.
    - `boolean removeFirstOccurrence(Object o)`: Removes the first occurrence of the specified element.
    - `boolean removeLastOccurrence(Object o)`: Removes the last occurrence of the specified element.

#### Example:
```java
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);
deque.addLast(2);
System.out.println(deque.pollFirst()); // Output: 1
System.out.println(deque.pollLast()); // Output: 2
```

#### Subclasses of Deque:

# ArrayDeque Class

- **Description**: The `ArrayDeque` class in Java is part of the `java.util` package and implements a resizable array-based double-ended queue (deque). It allows elements to be added or removed from both ends efficiently. Unlike a standard queue, `ArrayDeque` does not permit `null` elements. It is not thread-safe but provides better performance than `LinkedList` for stack and queue operations.

- **Methods**:
    - **ArrayDeque-Specific Methods:**
        - `void addFirst(E e)`: Inserts the specified element at the front of this deque.
        - `void addLast(E e)`: Inserts the specified element at the end of this deque.
        - `boolean offerFirst(E e)`: Inserts the specified element at the front of this deque.
        - `boolean offerLast(E e)`: Inserts the specified element at the end of this deque.
        - `E getFirst()`: Retrieves, but does not remove, the first element of this deque.
        - `E getLast()`: Retrieves, but does not remove, the last element of this deque.
        - `E pollFirst()`: Retrieves and removes the first element of this deque, or returns `null` if this deque is empty.
        - `E pollLast()`: Retrieves and removes the last element of this deque, or returns `null` if this deque is empty.
        - `boolean removeFirstOccurrence(Object o)`: Removes the first occurrence of the specified element in this deque.
        - `boolean removeLastOccurrence(Object o)`: Removes the last occurrence of the specified element in this deque.
        - `boolean contains(Object o)`: Returns `true` if this deque contains the specified element.
        - `int size()`: Returns the number of elements in this deque.
        - `void clear()`: Removes all elements from the deque.
        - `Object[] toArray()`: Returns an array containing all elements in this deque.
        - `<T> T[] toArray(T[] a)`: Returns an array containing all elements in this deque, using the specified array.

#### Example:
```java
package Collection;

import java.util.*;

public class ArrayDequeEx {
    public static void main(String[] args) {
        // Create an ArrayDeque of Strings
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Add elements to the ArrayDeque
        deque.addFirst("Element1");
        deque.addLast("Element2");
        deque.addFirst("Element3");
        deque.addLast("Element4");

        // Display the ArrayDeque
        System.out.println("ArrayDeque: " + deque);

        // Retrieve elements from both ends
        String first = deque.getFirst();
        String last = deque.getLast();
        System.out.println("First Element: " + first);
        System.out.println("Last Element: " + last);

        // Remove elements from both ends
        String removedFirst = deque.pollFirst();
        String removedLast = deque.pollLast();
        System.out.println("Removed First Element: " + removedFirst);
        System.out.println("Removed Last Element: " + removedLast);

        // Check if an element is present
        boolean contains = deque.contains("Element2");
        System.out.println("Contains 'Element2': " + contains);

        // Iterate over the elements
        System.out.println("Iterating over ArrayDeque:");
        for (String element : deque) {
            System.out.println(element);
        }

        // Use offer to add elements
        deque.offerFirst("NewElement1");
        deque.offerLast("NewElement2");
        System.out.println("ArrayDeque after offers: " + deque);

        // Convert ArrayDeque to an array
        Object[] array = deque.toArray();
        System.out.println("Array representation: " + Arrays.toString(array));

        // Get the size of the ArrayDeque
        int size = deque.size();
        System.out.println("Size of ArrayDeque: " + size);

        // Clear the ArrayDeque
        deque.clear();
        System.out.println("ArrayDeque after clearing: " + deque);

        // Check if the ArrayDeque is empty
        boolean isEmpty = deque.isEmpty();
        System.out.println("Is ArrayDeque Empty: " + isEmpty);
    }
}
```

2. **LinkedList**
    - **Description**: Implements both `Queue` and `Deque`. Supports insertion and removal at both ends. Maintains the insertion order and allows `null` elements.
    - **Methods**:
        - `void addFirst(E e)`: Inserts the specified element at the front.
        - `void addLast(E e)`: Inserts the specified element at the end.
        - `boolean offerFirst(E e)`: Inserts the specified element at the front. Returns `false` if the operation fails.
        - `boolean offerLast(E e)`: Inserts the specified element at the end. Returns `false` if the operation fails.
        - `E removeFirst()`: Removes and retrieves the first element. Throws an exception if the deque is empty.
        - `E removeLast()`: Removes and retrieves the last element. Throws an exception if the deque is empty.
        - `E pollFirst()`: Removes and retrieves the first element. Returns `null` if the deque is empty.
        - `E pollLast()`: Removes and retrieves the last element. Returns `null` if the deque is empty.
        - `E getFirst()`: Retrieves the first element without removing it. Throws an exception if the deque is empty.
        - `E getLast()`: Retrieves the last element without removing it. Throws an exception if the deque is empty.
        - `E peekFirst()`: Retrieves the first element without removing it. Returns `null` if the deque is empty.
        - `E peekLast()`: Retrieves the last element without removing it. Returns `null` if the deque is empty.
        - `boolean removeFirstOccurrence(Object o)`: Removes the first occurrence of the specified element.
        - `boolean removeLastOccurrence(Object o)`: Removes the last occurrence of the specified element.

   #### Example:
   ```java
   Deque<Integer> linkedListDeque = new LinkedList<>();
   linkedListDeque.addFirst(1);
   linkedListDeque.addLast(2);
   System.out.println(linkedListDeque.getFirst()); // Output: 1
   System.out.println(linkedListDeque.getLast()); // Output: 2
   ```
   
## `Collections` Class
- **Description**: The `Collections` class provides static methods to manipulate or process collections in Java. It includes operations like sorting, shuffling, searching, and more.
- **Methods**:
    - `void sort(List<T> list)`: Sorts the specified list in ascending order.
    - `void sort(List<T> list, Comparator<? super T> c)`: Sorts the specified list according to the order induced by the comparator.
    - `void reverse(List<?> list)`: Reverses the order of the elements in the specified list.
    - `void shuffle(List<?> list)`: Randomly shuffles the elements in the list.
    - `void shuffle(List<?> list, Random rnd)`: Randomly shuffles the elements using the specified random generator.
    - `T max(Collection<? extends T> coll)`: Returns the maximum element of the collection according to natural ordering.
    - `T max(Collection<? extends T> coll, Comparator<? super T> comp)`: Returns the maximum element using a comparator.
    - `T min(Collection<? extends T> coll)`: Returns the minimum element of the collection according to natural ordering.
    - `T min(Collection<? extends T> coll, Comparator<? super T> comp)`: Returns the minimum element using a comparator.
    - `int frequency(Collection<?> coll, Object o)`: Returns the number of occurrences of the specified element.
    - `boolean replaceAll(List<T> list, T oldVal, T newVal)`: Replaces all occurrences of oldVal with newVal.
    - `void rotate(List<?> list, int distance)`: Rotates the elements by the specified distance.
    - `void swap(List<?> list, int i, int j)`: Swaps the elements at the specified positions.
    - `void copy(List<? super T> dest, List<? extends T> src)`: Copies all elements from source to destination.
    - `void fill(List<? super T> list, T obj)`: Replaces all elements in the list with the specified value.
    - `List<T> nCopies(int n, T obj)`: Returns an immutable list containing n copies of the specified object.
    - `List<T> unmodifiableList(List<? extends T> list)`: Returns an unmodifiable view of the specified list.
    - `Set<T> unmodifiableSet(Set<? extends T> s)`: Returns an unmodifiable view of the specified set.
    - `Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)`: Returns an unmodifiable view of the specified map.
    - `Collection<T> synchronizedCollection(Collection<T> c)`: Returns a synchronized (thread-safe) collection backed by the specified collection.
    - `List<T> synchronizedList(List<T> list)`: Returns a synchronized list.
    - `Set<T> synchronizedSet(Set<T> s)`: Returns a synchronized set.
    - `Map<K, V> synchronizedMap(Map<K, V> m)`: Returns a synchronized map.
    - `boolean disjoint(Collection<?> c1, Collection<?> c2)`: Checks if two collections have no elements in common.

#### Example:
```java
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
```