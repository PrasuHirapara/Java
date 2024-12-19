# Entity Layer
The Entity Layer in a Spring Boot application serves as the foundation for database interactions. It represents the domain model of the application and maps Java classes to database tables using ORM (Object-Relational Mapping) frameworks like Hibernate. This layer is pivotal for bridging the gap between the application and the database, ensuring seamless persistence and retrieval of data.

### Advantages
- **Simplified Database Operations:** Provides an abstraction over database interactions.
- **Object-Oriented Approach:** Maps database tables to Java objects.
- **Reduced Boilerplate Code:** Annotations and frameworks minimize repetitive code.
- **Integration with JPA:** Leverages Java Persistence API for portability.
- **Database Agnostic:** Allows switching databases with minimal changes.

### Use Cases
- Applications requiring persistent storage of structured data.
- Systems leveraging relational databases like MySQL, PostgreSQL, or Oracle.
- CRUD-based applications with complex entity relationships.
- Multi-module projects requiring separation of concerns.

## Key Annotations in the Entity Layer

### 1. `@Entity`
Marks a class as a JPA entity.
```java
@Entity
public class User {
    @Id
    private Long id;
}
```

### 2. `@Table`
Specifies the database table name for an entity.
- **name:** Specifies the table name in the database.
```java
@Entity
@Table(name = "users")
public class User {
}
```

### 3. `@Id`
Denotes the primary key of an entity.
```java
@Id
private Long id;
```

### 4. `@GeneratedValue`
Defines the strategy for primary key generation.
- **strategy:** Specifies the generation strategy. Possible values:
    - **AUTO:** Automatically selects an appropriate strategy.
    - **IDENTITY:** Uses identity columns in the database.
    - **SEQUENCE:** Uses a database sequence.
    - **TABLE:** Uses a database table for key generation.
```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

### 5. `@Column`
Customizes a column's mapping in the table.
- **name:** Specifies the column name.
- **nullable:** Defines whether the column can be null.
- **unique:** Ensures the column values are unique.
```java
@Column(name = "username", nullable = false, unique = true)
private String username;
```

### 6. `@OneToMany`
Defines a one-to-many relationship.
- **mappedBy:** Specifies the field that owns the relationship.
- **cascade:** Defines cascading operations (e.g., `CascadeType.ALL`, `PERSIST`, `REMOVE`).
```java
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Post> posts;
```

### 7. `@ManyToOne`
Specifies a many-to-one relationship.
- **fetch:** Defines the fetch strategy (`FetchType.EAGER` or `FetchType.LAZY`).
- **optional:** Indicates whether the relationship is optional.
```java
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "user_id")
private User user;
```

### 8. `@JoinColumn`
Customizes the foreign key column.
- **name:** Specifies the column name.
- **nullable:** Defines whether the column can be null.
- **referencedColumnName:** Specifies the referenced column in the parent entity.
```java
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;
```

### 9. `@Embedded`
Embeds a class into an entity.
```java
@Embedded
private Address address;
```

### 10. `@Embeddable`
Marks a class as embeddable in an entity.
```java
@Embeddable
public class Address {
    private String street;
    private String city;
}
```

## Using Lombok in the Entity Layer
Lombok eliminates boilerplate code by auto-generating getters, setters, and other methods.

### Example with Lombok
```java
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
```

## Steps to Implement an Entity Layer

1. **Add JPA Dependency:**
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>
   ```

2. **Create an Entity Class:**
   ```java
   @Entity
   @Table(name = "users")
   public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       @Column(nullable = false)
       private String name;
   }
   ```

3. **Configure Database in `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/mydb
   spring.datasource.username=root
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Create Repository Interface:**
   ```java
   public interface UserRepository extends JpaRepository<User, Long> {
   }
   ```

5. **Inject and Use Repository in Service Layer:**
   ```java
   @Service
   public class UserService {
       @Autowired
       private UserRepository userRepository;

       public User saveUser(User user) {
           return userRepository.save(user);
       }
   }
   ```

## Best Practices
- **Use DTOs:** Avoid exposing entities directly in controllers.
- **Validation:** Use `@NotNull`, `@Size`, and other validation annotations for input validation.
- **Lazy Loading:** Configure lazy loading for collections to optimize performance.
- **Avoid Business Logic in Entities:** Keep entities focused on persistence logic only.
- **Define Explicit Fetch Strategies:** Use `@Fetch` or `JOIN FETCH` to manage relationships effectively.
- **Audit Fields:** Use `@CreatedDate` and `@LastModifiedDate` for auditing.

## Conclusion
The Entity Layer in Spring Boot is crucial for defining and managing the application's data model. By leveraging annotations, frameworks like JPA, and tools like Lombok, developers can create clean, efficient, and maintainable entity classes. Adopting best practices ensures optimal performance and scalability, making the application robust and future-proof.
