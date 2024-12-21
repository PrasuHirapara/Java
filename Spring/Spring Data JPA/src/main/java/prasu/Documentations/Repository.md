# Repository Interface

The repository layer in Spring Data JPA provides an abstraction for data access and manipulation. By extending predefined interfaces, such as `JpaRepository`, developers can leverage powerful CRUD operations, pagination, and custom queries with minimal boilerplate code.

---

## Advantages
1. **Simplified Development**: Predefined methods reduce boilerplate code for common operations.
2. **Custom Queries**: Flexible query creation with JPQL and native SQL support.
3. **Seamless Integration**: Works well with Spring’s dependency injection and transaction management.
4. **Pagination and Sorting**: Built-in support for pagination and sorting of results.
5. **Type Safety**: Strongly-typed methods using generics.

---

## Use Cases
1. **Basic CRUD Operations**: Create, read, update, and delete entities.
2. **Custom Query Execution**: Execute queries using JPQL, native SQL, or named parameters.
3. **Pagination**: Fetch large datasets in smaller, manageable chunks.
4. **Sorting**: Retrieve ordered datasets based on specific fields.
5. **Transactional Updates**: Perform transactional modifications on data.

---

## Key Annotations and Examples

### 1. @Repository
- **Purpose**: Marks the interface as a Spring Data repository.
- **Example**:
  ```java
  @Repository
  public interface StudentRepository extends JpaRepository<Student, Long> {}
  ```

### 2. JpaRepository
- **Purpose**: Provides CRUD operations and additional JPA-related methods like pagination and sorting.
- **Example**:
  ```java
  public interface CourseRepository extends JpaRepository<Course, Long> {}
  ```

### 3. @Query
- **Purpose**: Used to define custom JPQL or native SQL queries.
- **Example (JPQL)**:
  ```java
  @Query("select s from Student s where s.emailId = ?1")
  Student getStudentByEmailAddress(String emailId);
  ```

- **Example (Native SQL)**:
  ```java
  @Query(value = "SELECT * FROM tbl_student s where s.email_address = ?1", nativeQuery = true)
  Student getStudentByEmailAddressNative(String emailId);
  ```

### 4. @Param
- **Purpose**: Binds named parameters in queries.
- **Example**:
  ```java
  @Query(value = "SELECT * FROM tbl_student s where s.email_address = :emailId", nativeQuery = true)
  Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
  ```

### 5. @Modifying
- **Purpose**: Indicates an update or delete query.
- **Example**:
  ```java
  @Modifying
  @Transactional
  @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
  int updateStudentNameByEmailId(String firstName, String emailId);
  ```

### 6. Pagination and Sorting
- **Purpose**: Handles large datasets and retrieves sorted results.
- **Example**:
  ```java
  Page<Course> findByTitleContaining(String title, Pageable pageable);
  ```

### 7. @Transactional
- **Purpose**: Manages transactions for specific repository methods.
- **Example**:
  ```java
  @Transactional
  int deleteByFirstName(String firstName);
  ```

### 8. @Lock
- **Purpose**: Specifies the locking mode for query execution.
- **Example**:
  ```java
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("select s from Student s where s.emailId = ?1")
  Student findAndLockByEmail(String emailId);
  ```

### 9. @EntityGraph
- **Purpose**: Defines a graph for loading associated entities.
- **Example**:
  ```java
  @EntityGraph(attributePaths = {"teacher"})
  List<Course> findByTitle(String title);
  ```

### 10. @EnableJpaRepositories
- **Purpose**: Enables JPA repositories during configuration.
- **Example**:
  ```java
  @EnableJpaRepositories(basePackages = "prasu.Repository")
  public class JpaConfig {}
  ```

---

## More About JPQL

### Overview
JPQL (Java Persistence Query Language) is a powerful, object-oriented query language used to retrieve and manipulate data in JPA entities. Unlike SQL, which operates on database tables, JPQL operates on entity objects.

### Key Features
1. **Entity-Oriented**: Queries are written using entity class and field names instead of table and column names.
2. **Dynamic Queries**: Supports parameterized queries for flexibility.
3. **Relationship Navigation**: Allows navigation through relationships using entity fields.
4. **Compatibility**: Portable across various JPA providers.

### Example Queries
1. **Select All Students**:
   ```java
   @Query("SELECT s FROM Student s")
   List<Student> findAllStudents();
   ```

2. **Filter by Field**:
   ```java
   @Query("SELECT s FROM Student s WHERE s.firstName = ?1")
   List<Student> findByFirstName(String firstName);
   ```

3. **Join Fetch**:
   ```java
   @Query("SELECT c FROM Course c JOIN FETCH c.teacher WHERE c.title = ?1")
   List<Course> findCoursesWithTeachers(String title);
   ```

4. **Aggregation**:
   ```java
   @Query("SELECT COUNT(s) FROM Student s WHERE s.guardianName = ?1")
   Long countByGuardianName(String guardianName);
   ```

JPQL enhances the flexibility and power of JPA by enabling developers to define precise, entity-centric queries for complex data retrieval needs. With support for joins, filtering, and aggregations, JPQL is a critical tool for creating dynamic and efficient data-driven applications.

---

## Examples of Repository Interfaces

### StudentRepository
```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);
}
```

### CourseRepository
```java
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
```

---

## Conclusion
The repository interface in Spring Data JPA is a vital component for efficient data management in modern applications. By leveraging `JpaRepository` and related annotations like `@Query`, `@Modifying`, and `@Transactional`, developers can handle complex data operations with ease. Its built-in support for pagination, sorting, and query execution makes it a powerful tool for creating scalable, data-driven applications.

