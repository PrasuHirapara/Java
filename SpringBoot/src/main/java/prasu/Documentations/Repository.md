# Repository Layer

The Repository Layer in Spring Boot provides an abstraction over database interactions. It is a critical part of the persistence layer, handling CRUD (Create, Read, Update, Delete) operations and enabling seamless integration with the underlying database. Spring Data JPA simplifies the implementation of repositories by offering pre-built interfaces and query methods.

---

## Advantages

1. **Reduces Boilerplate Code**: Automatically provides CRUD operations.
2. **Easy Query Customization**: Supports both method-based and JPQL queries.
3. **Database Agnostic**: Enables switching between databases with minimal effort.
4. **Integration with Spring Framework**: Works seamlessly with Spring for dependency injection and transactions.

---

## Use Cases

- Applications requiring CRUD operations on database entities.
- Systems with complex query requirements.
- Multi-module projects needing a separation of data access logic.

---

## Key Annotations in the Repository Layer

### 1. `@Repository`
- Marks a class as a Spring repository, enabling exception translation.
- **Used for:** Custom repository implementations.

Example:
```java
@Repository
public class CustomUserRepository {
    // Custom data access logic
}
```

### 2. `@Transactional`
- Manages transaction boundaries for methods or classes.
- **readOnly**: Set to `true` for read-only operations to optimize performance.
- **rollbackFor**: Specifies exceptions for rollback.

Example:
```java
@Transactional(readOnly = true)
public List<User> findAllUsers() {
    return userRepository.findAll();
}
```

### 3. `@Modifying`
- Indicates a modifying query for `@Query`-based updates or deletes.
- **clearAutomatically**: Clears persistence context after operation.

Example:
```java
@Modifying(clearAutomatically = true)
@Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
void updateUserName(@Param("id") Long id, @Param("name") String name);
```

### 4. `@Query`
- Defines custom JPQL or native SQL queries.
- **value**: Specifies the query string.
- **nativeQuery**: Set to `true` for native SQL.

Example:
```java
@Query("SELECT u FROM User u WHERE u.name = :name")
List<User> findUsersByName(@Param("name") String name);
```

### 5. `@Param`
- Binds method parameters to query parameters.
- **value**: Maps the parameter to a named query placeholder.

Example:
```java
@Query("SELECT u FROM User u WHERE u.email = :email")
User findByEmail(@Param("email") String email);
```

### 6. `@EnableJpaRepositories`
- Enables JPA repository scanning.
- **basePackages**: Specifies the package(s) to scan for repositories.

Example:
```java
@EnableJpaRepositories(basePackages = "com.example.repositories")
public class AppConfig {
}
```

### 7. `@Lock`
- Specifies a locking mode for a query.
- **value**: Defines the lock type (`LockModeType.READ` or `LockModeType.WRITE`).

Example:
```java
@Lock(LockModeType.PESSIMISTIC_WRITE)
@Query("SELECT u FROM User u WHERE u.id = :id")
User findUserForUpdate(@Param("id") Long id);
```

### 8. `@PersistenceContext`
- Injects the `EntityManager` for custom repository logic.
- **unitName**: Specifies the persistence unit.

Example:
```java
@PersistenceContext
private EntityManager entityManager;
```

### 9. `@NoRepositoryBean`
- Prevents instantiation of a base repository interface.

Example:
```java
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    // Common methods for all repositories
}
```

### 10. `@Procedure`
- Maps stored procedures to repository methods.
- **procedureName**: Specifies the procedure name.

Example:
```java
@Procedure("update_user_status")
void updateUserStatus(@Param("id") Long id, @Param("status") String status);
```

---

## Steps to Implement the Repository Layer

### 1. **Add Spring Data JPA Dependency**

Add the following dependency to your `pom.xml`:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### 2. **Create a Repository Interface**

Example:
```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name); // Find users by name
}
```

### 3. **Customize Query Logic (Optional)**

Example:
```java
@Repository
public class CustomUserRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findActiveUsers() {
        String query = "SELECT u FROM User u WHERE u.active = true";
        return entityManager.createQuery(query, User.class).getResultList();
    }
}
```

### 4. **Enable JPA Repositories**

Example:
```java
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.repositories")
public class Application {
}
```

### 5. **Inject and Use Repository in Service Layer**

Example:
```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user); // Save a user to the database
    }
}
```

---

## Repository Methods for Database Operations

### GET Operations
1. `Optional<T> findById(ID id)` - Find an entity by its ID.
2. `List<T> findAll()` - Retrieve all entities.
3. `Page<T> findAll(Pageable pageable)` - Retrieve entities with pagination.
4. `List<T> findByName(String name)` - Find entities by name.
5. `List<T> findByActive(boolean active)` - Find entities based on their active status.
6. `Optional<T> findFirstByOrderByCreatedAtDesc()` - Get the most recently created entity.
7. `List<T> findTop10ByOrderByScoreDesc()` - Retrieve the top 10 entities by score.
8. `boolean existsById(ID id)` - Check if an entity exists by ID.
9. `long count()` - Count the total number of entities.
10. `List<T> findDistinctByRole(String role)` - Retrieve distinct entities by role.

### POST Operations
1. `T save(T entity)` - Save a new entity.
2. `List<T> saveAll(Iterable<T> entities)` - Save a list of entities.

### PUT Operations
1. `T save(T entity)` - Update an entity if its ID exists.
2. `@Modifying @Query("UPDATE ...")` - Execute a custom update query.

### DELETE Operations
1. `void delete(T entity)` - Delete a specific entity.
2. `void deleteById(ID id)` - Delete an entity by its ID.
3. `void deleteAll()` - Delete all entities.
4. `void deleteAllInBatch()` - Delete all entities in a batch operation.

---

## Best Practices

1. **Avoid Business Logic**: Keep repositories focused on data access.
2. **Use DTOs**: Return DTOs for query results instead of entities.
3. **Pagination and Sorting**: Leverage `Pageable` and `Sort` for large datasets.
4. **Query Performance**: Use proper indexing and avoid N+1 queries.
5. **Transaction Management**: Use `@Transactional` judiciously to manage transactions.
6. **Custom Implementations**: Extend default repositories for complex logic.

---

## Conclusion

The Repository Layer in Spring Boot abstracts database interactions, simplifying CRUD operations and query execution. With Spring Data JPA and annotations, developers can focus on business logic while the framework handles the intricacies of data access. Adhering to best practices ensures maintainability and scalability, making the application robust and efficient.
