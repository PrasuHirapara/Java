# Paging
Paging is the process of dividing large datasets into pages, making it easier to display data in parts. It optimizes performance by retrieving only the required subset of data at a time instead of loading the entire dataset into memory.

---

## Advantages
1. **Performance Optimization**: Reduces memory usage and improves response time by fetching data incrementally.
2. **User Experience**: Supports paginated views for better readability and navigation.
3. **Simplified Implementation**: Built-in support with minimal code changes.
4. **Customizable**: Flexible configuration for page size, sorting, and filtering.

---

## Key Components and Annotations

### 1. `Pageable`
- **Purpose**: Interface used to specify pagination and sorting information.
- **Example**:
  ```java
  Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("title"));
  ```

### 2. `PageRequest`
- **Purpose**: Static factory class for creating `Pageable` instances.
- **Example**:
  ```java
  PageRequest pageRequest = PageRequest.of(0, 10);
  ```

### 3. `Page`
- **Purpose**: Represents a single page of data and provides metadata such as total elements and pages.
- **Example**:
  ```java
  Page<Course> courses = courseRepository.findByTitleContaining("Spring", pageRequest);
  ```

### 4. `Sort`
- **Purpose**: Defines sorting criteria for query results.
- **Example**:
  ```java
  Sort sort = Sort.by(Sort.Direction.ASC, "title");
  ```

### 5. Repository Methods for Paging
- **Purpose**: Define methods in the repository to support pagination and sorting.
- **Example**:
  ```java
  Page<Course> findByTitleContaining(String title, Pageable pageable);
  ```

---

## Implementation Steps
1. **Define Repository Method**:
   Add a method in the repository interface to support pagination.
   ```java
   Page<Student> findByFirstNameContaining(String name, Pageable pageable);
   ```

2. **Create Pageable Instance**:
   Use `PageRequest` to create a pageable object specifying page number, size, and sorting criteria.
   ```java
   Pageable pageable = PageRequest.of(0, 5, Sort.by("lastName"));
   ```

3. **Call Repository Method**:
   Pass the pageable instance to the repository method.
   ```java
   Page<Student> students = studentRepository.findByFirstNameContaining("John", pageable);
   ```

4. **Access Metadata**:
   Use `Page` object methods to retrieve additional information.
   ```java
   int totalPages = students.getTotalPages();
   long totalElements = students.getTotalElements();
   List<Student> content = students.getContent();
   ```

---

## Example Code Snippets

### Repository Method
```java
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
```

### Service Layer
```java
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> getCourses(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title"));
        return courseRepository.findByTitleContaining(title, pageable);
    }
}
```

### Controller Layer
```java
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Page<Course> getCourses(@RequestParam String title,
                                    @RequestParam int page,
                                    @RequestParam int size) {
        return courseService.getCourses(title, page, size);
    }
}
```

---

## Conclusion
Paging in Spring Data JPA is an essential feature for applications handling large datasets. It enhances performance, simplifies implementation, and improves user experience by enabling seamless paginated and sorted data retrieval. By leveraging `Pageable`, `PageRequest`, and related components, developers can easily integrate paging functionality into their applications.

