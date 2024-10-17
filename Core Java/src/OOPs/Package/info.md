## Package
A package is a collection of different classes. It helps in organizing classes and solving conflicts that may arise from having multiple classes with the same name.

### Benefits:
- **Prevents Conflicts**: Resolves the issue of having multiple classes with the same name by organizing them into packages.

### Importing Classes and Methods:

1. **Importing a Class from a Package**:
    - Use this when you want to import a specific class.
    - **Example**:
      ```java
      import OOPs.Class.Student;
      ```

2. **Importing a Method from a Class**:
    - For importing a static method, use the `static` keyword.
    - **Example**:
      ```java
      import static OOPs.Class.Student.getStudent;
      ```

3. **Importing Everything from a Package**:
    - Use the `*` to import all classes and methods from a package.
    - **Example**:
      ```java
      import static OOPs.Class.*;
      ```

### Access Modifiers
Access modifiers control the visibility of classes, methods, and other members. Here’s a summary table:

| Access Modifier | Class Member Visibility | Subclass Visibility | Package Visibility | Outside Package Visibility |
|------------------|------------------------|---------------------|--------------------|----------------------------|
| **public**       | ✓                      | ✓                   | ✓                  | ✓                          |
| **protected**    | ✓                      | ✓                   | ✓                  | ✗                          |
| **private**      | ✓                      | ✗                   | ✗                  | ✗                          |
| **default**      | ✓                      | ✗                   | ✓                  | ✗                          |

### Notes:
- **public**: Members declared as public are accessible from any other class in any package.
- **protected**: Members declared as protected are accessible within the same package and by subclasses.
- **private**: Members declared as private are only accessible within the class they are declared.
- **default**: Members with no modifier (default) are accessible only within the same package.
