# Entity Class
Entity classes are core building blocks in Spring Data JPA for defining database schemas and managing the persistence of Java objects. They bridge the gap between relational databases and object-oriented applications by allowing developers to manipulate database tables through Java objects.

## Advantages
1. **Abstraction**: Simplifies database interactions by abstracting SQL queries.
2. **Object-Oriented Approach**: Enables developers to work with Java objects instead of raw SQL.
3. **Maintainability**: Reduces boilerplate code and centralizes schema definitions.
4. **Integration**: Seamlessly works with Spring ecosystem and other JPA providers.
5. **Relationship Management**: Provides intuitive annotations for defining complex relationships like one-to-one, one-to-many, and many-to-many.

---

## Use Cases
1. **Data Modeling**: Structuring the database schema in an object-oriented way.
2. **Relationship Management**: Defining and managing relationships between tables.
3. **CRUD Operations**: Simplifying create, read, update, and delete operations.
4. **Transactional Operations**: Handling data consistency and integrity within transactions.

---

## Key Annotations and Examples

### 1. @Entity
- **Purpose**: Specifies that a class is an entity and is mapped to a database table.
- **Example**:
  ```java
  @Entity
  public class Course {}
  ```

### 2. @Id
- **Purpose**: Marks the primary key field of the entity.
- **Example**:
  ```java
  @Id
  private Long courseId;
  ```

### 3. @GeneratedValue
- **Purpose**: Specifies how the primary key value is generated.
- **Example**:
  ```java
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
  ```

### 4. @SequenceGenerator
- **Purpose**: Defines a sequence generator for generating primary key values.
- **Example**:
  ```java
  @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
  ```

### 5. @OneToOne
- **Purpose**: Defines a one-to-one relationship between two entities.
- **Example**:
  ```java
  @OneToOne(mappedBy = "course")
  private CourseMaterial courseMaterial;
  ```

### 6. @ManyToOne
- **Purpose**: Defines a many-to-one relationship.
- **Example**:
  ```java
  @ManyToOne
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
  private Teacher teacher;
  ```

### 7. @ManyToMany
- **Purpose**: Defines a many-to-many relationship between two entities.
- **Example**:
  ```java
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "student_course_map",
      joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
      inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")
  )
  private List<Student> students;
  ```

### 8. @JoinColumn
- **Purpose**: Defines the foreign key column in relationships.
- **Example**:
  ```java
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
  ```

### 9. @Embeddable
- **Purpose**: Marks a class to be embedded in other entities.
- **Example**:
  ```java
  @Embeddable
  public class Guardian {
      private String name;
      private String email;
      private String mobile;
  }
  ```

### 10. @AttributeOverrides
- **Purpose**: Customizes the mapping of embedded fields.
- **Example**:
  ```java
  @AttributeOverrides({
      @AttributeOverride(name = "name", column = @Column(name = "guardian_name")),
      @AttributeOverride(name = "email", column = @Column(name = "guardian_email"))
  })
  ```

### 11. @Column
- **Purpose**: Customizes the mapping of a field to a database column.
- **Example**:
  ```java
  @Column(name = "guardian_email")
  private String email;
  ```

### 12. @Builder
- **Purpose**: Used for creating builder patterns with Lombok.
- **Example**:
  ```java
  @Builder
  public class Course {}
  ```

### 13. @Data
- **Purpose**: Lombok annotation to generate getters, setters, and other utility methods.
- **Example**:
  ```java
  @Data
  public class Course {}
  ```

### 14. @NoArgsConstructor and @AllArgsConstructor
- **Purpose**: Generate constructors with and without arguments.
- **Example**:
  ```java
  @NoArgsConstructor
  @AllArgsConstructor
  public class Course {}
  ```

### 15. @ToString
- **Purpose**: Excludes fields from the generated `toString()` method.
- **Example**:
  ```java
  @ToString(exclude = "course")
  public class CourseMaterial {}
  ```

### 16. @CascadeType
- **Purpose**: Defines cascading behavior for operations like persist, merge, etc.
- **Example**:
  ```java
  @ManyToOne(cascade = CascadeType.ALL)
  ```

### 17. @FetchType
- **Purpose**: Defines fetch strategy as eager or lazy.
- **Example**:
  ```java
  @OneToOne(fetch = FetchType.LAZY)
  ```

### 18. @Optional
- **Purpose**: Specifies whether a relationship is optional.
- **Example**:
  ```java
  @OneToOne(optional = false)
  ```

### 19. @MappedBy
- **Purpose**: Specifies the owning side of a relationship.
- **Example**:
  ```java
  @OneToOne(mappedBy = "course")
  ```

### 20. @JoinTable
- **Purpose**: Specifies the join table for many-to-many relationships.
- **Example**:
  ```java
  @JoinTable(name = "student_course_map")
  ```

---

## Conclusion
Entity classes in Spring Data JPA provide a powerful mechanism to manage database tables using Java objects. With intuitive annotations and seamless integration with the Spring ecosystem, they enable developers to define relationships, constraints, and behavior in a maintainable and efficient manner. Understanding and leveraging these annotations ensures a robust and scalable database design for enterprise applications.

