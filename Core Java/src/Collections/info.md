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

1. **HashSet**
    - **Description**: Implements a hash table for storing elements.
    - **Advantages**: Fast operations (add, remove, contains).
    - **Methods**:
        - `boolean add(E e)`: Adds an element.
        - `boolean remove(Object o)`: Removes an element.
        - `int size()`: Returns the size of the set.
        - `void clear()`: Clears the set.
        - `boolean contains(Object o)`: Checks if an element exists.
        - `boolean isEmpty()`: Checks if the set is empty.
        - `Iterator<E> iterator()`: Returns an iterator for traversal.

   #### Example:
   ```java
   HashSet<Integer> hashSet = new HashSet<>();
   hashSet.add(10);
   hashSet.add(20);
   System.out.println(hashSet.contains(10));
   ```

2. **LinkedHashSet**
    - **Description**: Maintains insertion order using a linked list.
    - **Advantages**: Predictable iteration order.
    - **Methods**:
        - `boolean add(E e)`: Adds an element.
        - `boolean remove(Object o)`: Removes an element.
        - `int size()`: Returns the size of the set.
        - `void clear()`: Clears the set.
        - `boolean contains(Object o)`: Checks if an element exists.
        - `boolean isEmpty()`: Checks if the set is empty.
        - `Iterator<E> iterator()`: Returns an iterator for traversal.

   #### Example:
   ```java
   LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
   linkedHashSet.add("A");
   linkedHashSet.add("B");
   System.out.println(linkedHashSet);
   ```

3. **TreeSet**
    - **Description**: Implements a red-black tree for storing elements in sorted order.
    - **Advantages**: Sorted elements.
    - **Methods**:
        - `boolean add(E e)`: Adds an element.
        - `boolean remove(Object o)`: Removes an element.
        - `int size()`: Returns the size of the set.
        - `void clear()`: Clears the set.
        - `boolean contains(Object o)`: Checks if an element exists.
        - `E first()`: Retrieves the first (lowest) element.
        - `E last()`: Retrieves the last (highest) element.
        - `E higher(E e)`: Retrieves the least element strictly greater than the given element.
        - `E lower(E e)`: Retrieves the greatest element strictly less than the given element.
        - `boolean isEmpty()`: Checks if the set is empty.
        - `Iterator<E> iterator()`: Returns an iterator for traversal.

   #### Example:
   ```java
   TreeSet<Integer> treeSet = new TreeSet<>();
   treeSet.add(5);
   treeSet.add(10);
   treeSet.add(1);
   System.out.println(treeSet.first()); // Output: 1
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

1. **HashMap**
    - **Description**: Implements a hash table for storing key-value pairs.
    - **Advantages**: Fast operations (get, put, remove).
    - **Methods**:
        - `V put(K key, V value)`: Associates the specified value with the specified key.
        - `V get(Object key)`: Returns the value to which the specified key is mapped.
        - `boolean containsKey(Object key)`: Checks if the map contains the specified key.
        - `boolean containsValue(Object value)`: Checks if the map contains the specified value.
        - `V remove(Object key)`: Removes the mapping for a key.
        - `int size()`: Returns the size of the map.
        - `boolean isEmpty()`: Checks if the map is empty.
        - `void clear()`: Clears the map.
        - `Set<K> keySet()`: Returns a set of all keys.

   #### Example:
   ```java
   HashMap<String, Integer> hashMap = new HashMap<>();
   hashMap.put("A", 1);
   hashMap.put("B", 2);
   System.out.println(hashMap.size()); // Output: 2
   ```

2. **LinkedHashMap**
    - **Description**: Maintains insertion order of key-value pairs.
    - **Advantages**: Predictable iteration order.
    - **Methods**:
        - `V put(K key, V value)`: Associates the specified value with the specified key.
        - `V get(Object key)`: Returns the value to which the specified key is mapped.
        - `boolean containsKey(Object key)`: Checks if the map contains the specified key.
        - `boolean containsValue(Object value)`: Checks if the map contains the specified value.
        - `V remove(Object key)`: Removes the mapping for a key.
        - `int size()`: Returns the size of the map.
        - `boolean isEmpty()`: Checks if the map is empty.
        - `Set<K> keySet()`: Returns a set of all keys.

   #### Example:
   ```java
   LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
   linkedHashMap.put(1, "A");
   linkedHashMap.put(2, "B");
   System.out.println(linkedHashMap.keySet());
   ```

3. **TreeMap**
    - **Description**: Implements a red-black tree for storing key-value pairs in sorted order.
    - **Advantages**: Sorted keys.
    - **Methods**:
        - `V put(K key, V value)`: Associates the specified value with the specified key.
        - `V get(Object key)`: Returns the value to which the specified key is mapped.
        - `boolean containsKey(Object key)`: Checks if the map contains the specified key.
        - `boolean containsValue(Object value)`: Checks if the map contains the specified value.
        - `V remove(Object key)`: Removes the mapping for a key.
        - `int size()`: Returns the size of the map.
        - `boolean isEmpty()`: Checks if the map is empty.
        - `Set<K> keySet()`: Returns a set of all keys.
        - `SortedMap<K, V> subMap(K fromKey, K toKey)`: Returns a view of the portion of this map whose keys range from `fromKey`, inclusive, to `toKey`, exclusive.
        - `K firstKey()`: Returns the first (lowest) key currently in the map.
        - `K lastKey()`: Returns the last (highest) key currently in the map.

   #### Example:
   ```java
   TreeMap<Integer, String> treeMap = new TreeMap<>();
   treeMap.put(3, "C");
   treeMap.put(1, "A");
   treeMap.put(2, "B");
   System.out.println(treeMap.firstKey()); // Output: 1
   ```

4. **Hashtable**
    - **Description**: Implements a hash table similar to `HashMap`, but is synchronized.
    - **Advantages**: Thread-safe.
    - **Methods**:
        - `V put(K key, V value)`: Associates the specified value with the specified key.
        - `V get(Object key)`: Returns the value to which the specified key is mapped.
        - `boolean containsKey(Object key)`: Checks if the map contains the specified key.
        - `boolean containsValue(Object value)`: Checks if the map contains the specified value.
        - `V remove(Object key)`: Removes the mapping for a key.
        - `int size()`: Returns the size of the map.
        - `boolean isEmpty()`: Checks if the map is empty.
        - `Set<K> keySet()`: Returns a set of all keys.

   #### Example:
   ```java
   Hashtable<String, Integer> hashtable = new Hashtable<>();
   hashtable.put("X", 100);
   hashtable.put("Y", 200);
   System.out.println(hashtable.get("X")); // Output: 100
   ```
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

1. **PriorityQueue**
    - **Description**: Implements a priority heap, ordering elements based on their natural order or a custom comparator. Does not allow null elements.
    - **Methods**:
        - `boolean add(E e)`: Inserts the specified element into the priority queue. Throws an exception if the operation fails.
        - `boolean offer(E e)`: Inserts the specified element into the priority queue. Returns `false` if the operation fails.
        - `E remove()`: Retrieves and removes the head of the priority queue. Throws an exception if the queue is empty.
        - `E poll()`: Retrieves and removes the head of the priority queue. Returns `null` if the queue is empty.
        - `E element()`: Retrieves the head of the priority queue without removing it. Throws an exception if the queue is empty.
        - `E peek()`: Retrieves the head of the priority queue without removing it. Returns `null` if the queue is empty.

   #### Example:
   ```java
   PriorityQueue<Integer> pq = new PriorityQueue<>();
   pq.add(10);
   pq.add(5);
   pq.add(20);
   System.out.println(pq.poll()); // Output: 5
   ```

2. **LinkedList**
    - **Description**: Implements both `Queue` and `Deque`. Maintains insertion order.
    - **Methods**:
        - `boolean add(E e)`: Inserts the specified element into the queue. Throws an exception if the operation fails.
        - `boolean offer(E e)`: Inserts the specified element into the queue. Returns `false` if the operation fails.
        - `E remove()`: Retrieves and removes the head of the queue. Throws an exception if the queue is empty.
        - `E poll()`: Retrieves and removes the head of the queue. Returns `null` if the queue is empty.
        - `E element()`: Retrieves the head of the queue without removing it. Throws an exception if the queue is empty.
        - `E peek()`: Retrieves the head of the queue without removing it. Returns `null` if the queue is empty.

   #### Example:
   ```java
   Queue<String> linkedListQueue = new LinkedList<>();
   linkedListQueue.add("A");
   linkedListQueue.add("B");
   System.out.println(linkedListQueue.poll()); // Output: A
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

1. **ArrayDeque**
    - **Description**: Implements a resizable array for `Deque` operations. Faster than `LinkedList` for `Deque` operations. Does not allow `null` elements.
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
   Deque<String> arrayDeque = new ArrayDeque<>();
   arrayDeque.add("X");
   arrayDeque.add("Y");
   System.out.println(arrayDeque.poll()); // Output: X
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

