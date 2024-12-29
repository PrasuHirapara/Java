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

1. **ArrayList**
    - **Description**: A resizable array.
    - **Advantages**: Fast random access.
    - **Methods**:
        - `boolean add(E e)`: Adds an element.
        - `E get(int index)`: Retrieves an element by index.
        - `E set(int index, E element)`: Replaces the element at the specified index.
        - `void ensureCapacity(int minCapacity)`: Increases the capacity of the list.
        - `int size()`: Returns the size of the list.
        - `boolean contains(Object o)`: Checks if the list contains an element.
        - `boolean remove(Object o)`: Removes an element by value.
        - `Object[] toArray()`: Converts the list to an array.

   #### Example:
   ```java
   ArrayList<String> arrayList = new ArrayList<>();
   arrayList.add("Java");
   arrayList.add("Python");
   System.out.println(arrayList.get(1));
   ```

2. **LinkedList**
    - **Description**: Doubly-linked list implementation of List and Deque.
    - **Advantages**: Efficient insertions and deletions.
    - **Methods**:
        - `boolean add(E e)`: Adds an element.
        - `E removeFirst()`: Removes the first element.
        - `E removeLast()`: Removes the last element.
        - `E getFirst()`: Retrieves the first element.
        - `E getLast()`: Retrieves the last element.
        - `E pollFirst()`: Retrieves and removes the first element.
        - `E pollLast()`: Retrieves and removes the last element.
        - `void addFirst(E e)`: Adds an element at the beginning.
        - `void addLast(E e)`: Adds an element at the end.

   #### Example:
   ```java
   LinkedList<Integer> linkedList = new LinkedList<>();
   linkedList.add(5);
   linkedList.add(10);
   System.out.println(linkedList.removeFirst());
   ```

3. **Vector**
    - **Description**: Synchronized dynamic array.
    - **Advantages**: Thread-safe.
    - **Methods**:
        - `boolean add(E e)`: Adds an element.
        - `E get(int index)`: Retrieves an element by index.
        - `int capacity()`: Returns the capacity of the vector.
        - `void trimToSize()`: Trims capacity to the current size.
        - `int size()`: Returns the number of elements.
        - `boolean isEmpty()`: Checks if the vector is empty.
        - `boolean contains(Object o)`: Checks if the vector contains an element.
        - `void clear()`: Clears the vector.

   #### Example:
   ```java
   Vector<String> vector = new Vector<>();
   vector.add("Item1");
   vector.add("Item2");
   System.out.println(vector.get(0));
   ```

4. **Stack**
    - **Description**: LIFO (Last-In-First-Out) data structure.
    - **Methods**:
        - `E push(E item)`: Pushes an item onto the stack.
        - `E pop()`: Removes the top item.
        - `E peek()`: Retrieves the top item without removing it.
        - `boolean empty()`: Checks if the stack is empty.
        - `int search(Object o)`: Returns the 1-based position of an element.
        - `int size()`: Returns the size of the stack.

   #### Example:
   ```java
   Stack<Integer> stack = new Stack<>();
   stack.push(10);
   stack.push(20);
   System.out.println(stack.pop()); // Output: 20
   ```

---

### 4. **Set Interface**